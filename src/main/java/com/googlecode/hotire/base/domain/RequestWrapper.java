package com.googlecode.hotire.base.domain;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.util.ContentCachingRequestWrapper;

/**
 * getContentAsByteArray method has to read HttpServletRequest getInputStream
 */
public class RequestWrapper extends ContentCachingRequestWrapper {
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }
    public String getBody() {
        return new String(super.getContentAsByteArray());
    }
}
