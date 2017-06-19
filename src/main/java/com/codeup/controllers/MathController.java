package com.codeup.controllers;

import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public int subtract(@PathVariable int number, @PathVariable int digit) {
        return number - digit;
    }
    @GetMapping("/multiply/{number}/and/{digit}")
    @ResponseBody
    public int multiply(@PathVariable int number, @PathVariable int digit) {
        return number * digit;
    }
    @GetMapping("/add/{number}/and/{digit}")
    @ResponseBody
    public int divide(@PathVariable int number, @PathVariable int digit) {
        return number / digit;
    }
}
