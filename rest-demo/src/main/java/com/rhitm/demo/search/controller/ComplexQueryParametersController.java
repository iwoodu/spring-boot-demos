package com.rhitm.demo.search.controller;

import javax.validation.Valid;

import com.rhitm.demo.search.dto.CityStateParam;
import com.rhitm.demo.search.dto.SearchParam;
import com.rhitm.demo.search.dto.UberSearchRequest;
import com.rhitm.demo.search.dto.ZipCodeParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Same endpoint, different combinations of parameters based on use case, where
 * parameters are encapsulated into a complex class.
 * 
 * Issues
 * <ul>
 *  <li>OpenAPI specification only shows one endpoint use case</li>
 * </ul>
 */
@RestController(value = "complexSearchController")
@RequestMapping("complexquery")
public class ComplexQueryParametersController {
    
    @GetMapping("/search")
    @ResponseBody
    public String search() {
        return "This result set contains all records.";
    }

    @GetMapping(value="/search/byzip")
    @ResponseBody
    public String search(ZipCodeParam zipCodeParam) {
        return String.format("This filtered result set contains records found for zip code [%s]",
                zipCodeParam.getZipCode());
    }

    @GetMapping(value = "/search/bycitystate")
    @ResponseBody
    public String search(final CityStateParam cityStateParam) {
        return String.format("This filtered result set contains records found for [%s, %s]", cityStateParam.getCity(),
                cityStateParam.getState());
    }

    @GetMapping(value = "/search/bypickone")
    @ResponseBody
    public String search(
            @RequestParam(required = false) final ZipCodeParam zipCodeParam,
            @RequestParam(required = false) final CityStateParam cityStateParam) {
        if (zipCodeParam == null && cityStateParam == null)
            return search();
        else if (zipCodeParam == null)
            return search(zipCodeParam);
        else
            return search(cityStateParam);
    }

    @GetMapping(value = "/search/bypickeither")
    @ResponseBody
    public String search(@Valid final UberSearchRequest uberSearchRequest) {
        return "Return results using the 'UberSearchRequest'";
    }

    @GetMapping(value = "/search/bypickeitheror")
    @ResponseBody
    public String search(
        @Valid 
        @Schema(oneOf = { ZipCodeParam.class, CityStateParam.class }) 
        final SearchParam searchParam) {
        return "Return results using the 'SearchParam'";
    }
}