package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by frenchfryes on 6/19/17.
 */
@Controller
public class PostsController {

    private final PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String viewAll(Model model) {

        List<Post> posts = postSvc.findAll();
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
        postSvc.save(post);
        return "posts/create";
    }
    @GetMapping("/posts/{id}/edit")
    public String showEditForms(@PathVariable long id, Model model){
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";

    }

    @GetMapping("/posts/create")
    public String savePost() {
        return "posts/create";
    }
}