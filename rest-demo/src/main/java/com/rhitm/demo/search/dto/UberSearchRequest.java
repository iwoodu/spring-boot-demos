package com.rhitm.demo.search.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    oneOf = {ZipCodeParam.class, CityStateParam.class}
)
public class UberSearchRequest implements SearchParam {
    ZipCodeParam zipCodeParam;
    CityStateParam cityStateParam;

    public UberSearchRequest(ZipCodeParam zipCodeParam, CityStateParam cityStateParam) {
        this.zipCodeParam = zipCodeParam;
        this.cityStateParam = cityStateParam;
    }
}