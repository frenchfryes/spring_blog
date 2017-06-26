package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        // Inside the method that shows an individual post, create a new post object and pass it to the view.
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post, Model model) {
        model.addAttribute("post", post);
        post.setOwner(userRepository.findOne(1L));
        postSvc.save(post);
        return "redirect:/posts/";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForms(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";

    }
    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String savePost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("post/delete")
    public String deletePost(@ModelAttribute Post post) {
        postSvc.deletePost(post.getId());
        return "redirect:/posts";
    }

}