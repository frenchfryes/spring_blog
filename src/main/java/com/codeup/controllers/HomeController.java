package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by frenchfryes on 6/19/17.
 */
@Controller
public class HomeController {
    @GetMapping("/resume")
    public String resume(){
        return "resume";
    }

}
