package com.rhitm.demo.search.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZipCodeParam implements SearchParam {
    
    @NotBlank
    private String zipCode;
}