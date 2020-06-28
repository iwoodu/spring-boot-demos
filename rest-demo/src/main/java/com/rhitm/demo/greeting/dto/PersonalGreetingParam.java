package com.rhitm.demo.greeting.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalGreetingParam implements GreetingParam {
    private String name;
}