package com.googlecode.hotire.base.controller;

import com.googlecode.hotire.base.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
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

    @PostMapping("/test/filter")
    public Message testFilter(@RequestBody Message message) {
        log.info(message.toString());
        return message;
    }

}
