package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by frenchfryes on 6/19/17.
 */
@Controller
public class MathController {
    @GetMapping("/add/{number}/and/{digit}")
    @ResponseBody
    public int add(@PathVariable int number, @PathVariable int digit) {
        return number + digit;
    }
    @GetMapping("/subtract/{number}/from/{digit}")
    public String add(@PathVariable int number1, @PathVariable int number2, Model model) {
//        return number1 + number2;
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);

        model.addAttribute("result", number1 + number2);

        model.addAttribute("numbers", new int[]{1, 2, 3, 4, 5});

        model.addAttribute("myBoolean", false);

        return "arithmetic/addition/result";
    }
    @GetMapping("/multiply/{number}/and/{digit}")
    @ResponseBody
    public int multiply(@PathVariable int number, @PathVariable int digit) {
        return number * digit;
    }
    @GetMapping("/divide/{number}/and/{digit}")
    @ResponseBody
    public int divide(@PathVariable int number, @PathVariable int digit) {
        return number / digit;
    }
}
