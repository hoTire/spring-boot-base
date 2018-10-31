package com.googlecode.hotire.base.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class Account {
    private Integer id;
    private String email;
    private String password;
    private BaseSessionInfo baseSessionInfo;
}
