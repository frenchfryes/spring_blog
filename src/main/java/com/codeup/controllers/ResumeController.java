package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by frenchfryes on 6/19/17.
 */
@Controller
public class ResumeController {
    @GetMapping("/pdf/web/viewer.html?file=ResumeoftheYear.pdf")
    public String resume(){
        return "/pdf/web/viewer";
    }

}
