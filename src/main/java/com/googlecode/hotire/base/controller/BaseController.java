package com.googlecode.hotire.base.controller;

import com.googlecode.hotire.base.domain.Message;
import com.googlecode.hotire.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class BaseController {

    @Autowired
    BaseService baseService;

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

    @GetMapping("/test/aop")
    public String testAOP() {
        log.info("test");
        return "Hello AOP";
    }

    @GetMapping("/test/name")
    public String test() {
        return baseService.getName();
    }

}
