package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


/**
 * Created by frenchfryes on 6/19/17.
 */
@Controller
public class PostsController {

    private final PostSvc postSvc;
    private final UsersRepository userRepository;

    @Autowired
    public PostsController(PostSvc postSvc, UsersRepository userRepository) {
        this.postSvc = postSvc;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {

        Iterable<Post> posts = postSvc.findAll();
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {

        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String saveAd(
            @Valid Post post,
            Errors validation,
            @RequestParam(name = "file") MultipartFile uploadedFile,
            Model model  // Model model = new Model();
    ) {
        // if (!passwordConfirm.equals(password)) { /* reject value */ }
        if (post.getTitle().endsWith("?")) {
            validation.rejectValue(
                    "title",
                    "post.title",
                    "You can't be unsure about your title!"
            );
        }

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }

        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);

        try {
            uploadedFile.transferTo(destinationFile);
//            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(user);
        post.setImageUrl(filename);
        postSvc.save(post);
        model.addAttribute("post", post);
        return "redirect:/posts";
    }

    @Value("${file-upload-path}")
    private String uploadPath;

    @GetMapping("/fileupload")
    public String showUploadFileForm() {
        return "fileupload";
    }


    @GetMapping("/posts/{id}/edit")
    public String showEditForms(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";

    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }


    @PostMapping("/post/delete")
    public String deletePost(@ModelAttribute Post post, Model model) {
        postSvc.deletePost(post.getId());
        model.addAttribute("msg", "Your post was deleted correctly");
        return "return the view with a success message";
    }

    @GetMapping("/posts.json")
    public @ResponseBody Iterable<Post> viewAllAds() {
        return postSvc.findAll();
    }

    @GetMapping("/posts/ajax")
    public String viewAllAdsUsingAnAjaxCall() {
        return "posts/ajax";
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/posts";
    }
}

