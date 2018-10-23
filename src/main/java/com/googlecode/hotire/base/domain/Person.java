package com.googlecode.hotire.base.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Person {
    private String name;
    private String gender;
    private int age;
}
