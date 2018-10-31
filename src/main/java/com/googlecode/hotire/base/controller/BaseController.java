package com.googlecode.hotire.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BaseController {

    @GetMapping({"/","/home"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    @GetMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello");
    }

}
