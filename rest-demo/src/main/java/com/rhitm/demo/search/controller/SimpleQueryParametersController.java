package com.rhitm.demo.search.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * Same endpoint, different combinations of parameters based on use case.
 * 
 * Issues
 * <ul>
 *  <li>OpenAPI specification only shows one endpoint use case</li>
 * </ul>
 */
@RestController(value = "simpleSearchController")
@RequestMapping("simplequery")
public class SimpleQueryParametersController {
    
    @Operation(description = "Returns all resources", summary = "Returns all records", tags = {"search"})
    @GetMapping(value = "/search")
    @ResponseBody
    public String search() {
        return "This result set contains all records.";
    }

    @Operation(description = "Returns all resources", summary = "Returns all records", tags = {"search by zip code"}, parameters = {@Parameter(name = "zipCode",description = "5 digit US zip code", example = "30040")})
    @GetMapping(value="/search", params = {"zipCode"})
    @ResponseBody
    public String search(@RequestParam String zipCode) {
        return String.format("This filtered result set contains records found for zip code [%s]", zipCode);
    }

    @Operation(description = "Returns all resources based on city,state", summary = "Returns all records based on city,state", tags = {"search by city,state"}, 
        parameters = {
            @Parameter(name = "city",description = "city name", example = "Atlanta"),
            @Parameter(name = "state",description = "2 character state abbreviation", example = "GA")
        })
    @GetMapping(value="/search", params = {"city", "state"})
    @ResponseBody
    public String search(@RequestParam String city, @RequestParam String state) {
        return String.format("This filtered result set contains records found for [%s, %s]", city, state);
    }

}