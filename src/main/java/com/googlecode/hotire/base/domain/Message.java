package com.googlecode.hotire.base.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String message, language;

    @Override
    public String toString() {
        return "{\"Message\":{"
                + "\"message\":\"" + message + "\""
                + ", \"language\":\"" + language + "\""
                + "}}";
    }
}
