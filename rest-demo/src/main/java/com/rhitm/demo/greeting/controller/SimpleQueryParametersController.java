package com.rhitm.demo.greeting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Same endpoint, different combinations of parameters based on use case.
 * 
 * Issues
 * <ul>
 *  <li>OpenAPI specification only shows one endpoint use case</li>
 * </ul>
 */
@RestController
@RequestMapping("simplequery")
public class SimpleQueryParametersController {
    
    @GetMapping("/greet")
    @ResponseBody
    public String greet() {
        return "Hello, friend!";
    }

    @GetMapping(value="/greet", params = {"name"})
    @ResponseBody
    public String greet(@RequestParam String name) {
        return String.format("Hello, %s", name);
    }

    @GetMapping(value="/greet", params = {"greeting", "name"})
    @ResponseBody
    public String greet(@RequestParam String greeting, @RequestParam String name) {
        return String.format("%s, %s", greeting, name);
    }

}