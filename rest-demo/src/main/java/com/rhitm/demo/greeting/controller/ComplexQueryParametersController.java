package com.rhitm.demo.greeting.controller;

import com.rhitm.demo.greeting.dto.CustomGreetingParam;
import com.rhitm.demo.greeting.dto.PersonalGreetingParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Same endpoint, different combinations of parameters based on use case, where
 * parameters are encapsulated into a complex class.
 * 
 * Issues
 * <ul>
 *  <li>OpenAPI specification only shows one endpoint use case</li>
 * </ul>
 */
@RestController
@RequestMapping("complexquery")
public class ComplexQueryParametersController {
    
    @GetMapping("/greet")
    @ResponseBody
    public String greet() {
        return "Hello, friend!";
    }

    @GetMapping(value="/personal/greet")
    @ResponseBody
    public String greet(PersonalGreetingParam greetingParam) {
        return String.format("Hello, %s", greetingParam.getName());
    }

    @GetMapping(value="/custom/greet")
    @ResponseBody
    public String greet(CustomGreetingParam greetingParam) {
        return String.format("%s, %s", greetingParam.getGreeting(), greetingParam.getName());
    }

}