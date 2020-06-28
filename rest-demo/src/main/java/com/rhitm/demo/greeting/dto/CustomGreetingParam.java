package com.rhitm.demo.greeting.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomGreetingParam implements GreetingParam {
    private String greeting;
    private String name;
}