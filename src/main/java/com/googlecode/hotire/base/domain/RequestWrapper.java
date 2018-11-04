package com.googlecode.hotire.base.domain;

import lombok.Getter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;

public class RequestWrapper extends ContentCachingRequestWrapper {
    @Getter private String body;
    public RequestWrapper(HttpServletRequest request) {
        super(request);
        body = new String(super.getContentAsByteArray());
    }
}
