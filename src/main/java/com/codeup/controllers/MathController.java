package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by frenchfryes on 6/19/17.
 */
@Controller
public class MathController {
    @RequestMapping(path = "/add/{number}/and/{digit}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int number, @PathVariable int digit) {
        return number + digit;
    }
    @RequestMapping(path = "/subtract/{number}/from/{digit}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int number, @PathVariable int digit) {
        return number - digit;
    }
    @RequestMapping(path = "/multiply/{number}/and/{digit}", method = RequestMethod.GET)
    @ResponseBody
    public int multiply(@PathVariable int number, @PathVariable int digit) {
        return number * digit;
    }
    @RequestMapping(path = "/add/{number}/and/{digit}", method = RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int number, @PathVariable int digit) {
        return number / digit;
    }
}
