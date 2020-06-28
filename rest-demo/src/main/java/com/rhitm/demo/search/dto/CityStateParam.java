package com.rhitm.demo.search.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityStateParam implements SearchParam {
    @NotBlank
    private String city;

    @NotBlank
    private String state;
}