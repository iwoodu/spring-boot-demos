package com.rhitm.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(
     name = "CustomGreeting",
     description = "Represents the request parameters for a custom greeting",
     oneOf = CustomGreetingParam.class
)@Getter
@Setter
public class CustomGreetingParam implements GreetingParam {
    private String greeting;
    private String name;
}