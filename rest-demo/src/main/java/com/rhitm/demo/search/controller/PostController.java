package com.rhitm.demo.search.controller;

import com.rhitm.demo.search.dto.CityStateParam;
import com.rhitm.demo.search.dto.ZipCodeParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "postSearchController")
public class PostController {

    @PostMapping("/search")
    @ResponseBody
    public String search() {
        return "This result set contains all records.";
    }

    @PostMapping(value="/search", params = "zipCode")
    @ResponseBody
    public String search(@RequestBody ZipCodeParam zipCodeParam) {
        return String.format("This filtered result set contains records found for zip code [%s]", zipCodeParam.getZipCode());
    }

    @PostMapping(value="/search", params = "cityState")
    @ResponseBody
    public String search(@RequestBody CityStateParam cityStateParam) {
        return String.format("This filtered result set contains records found for [%s, %s]", cityStateParam.getCity(), cityStateParam.getState());
    }

    
}