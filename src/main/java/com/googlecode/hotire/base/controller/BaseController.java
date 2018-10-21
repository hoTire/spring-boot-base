package com.googlecode.hotire.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/base")
public class BaseController {
    @GetMapping()
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
