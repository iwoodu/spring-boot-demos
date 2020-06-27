package com.rhitm.demo.controller;

import com.rhitm.demo.dto.CustomGreetingParam;
import com.rhitm.demo.dto.PersonalGreetingParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/greet")
    @ResponseBody
    public String greet() {
        return "Hello, friend!";
    }

    @PostMapping(value="/greet", params = "personal")
    @ResponseBody
    public String greet(@RequestBody PersonalGreetingParam greetingParam) {
        return String.format("Hello, %s", greetingParam.getName());
    }

    @PostMapping(value="/greet", params = "custom")
    @ResponseBody
    public String greet(@RequestBody CustomGreetingParam greetingParam) {
        return String.format("%s, %s", greetingParam.getGreeting(), greetingParam.getName());
    }

    
}