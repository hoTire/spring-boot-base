package com.googlecode.hotire.base.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Account {
    private Integer id;
    private String email;
    private String password;
}
