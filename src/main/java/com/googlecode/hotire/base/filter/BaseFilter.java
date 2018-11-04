package com.googlecode.hotire.base.filter;

import com.googlecode.hotire.base.domain.RequestWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * logging request body
 */
@Slf4j
public class BaseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest)request);
        chain.doFilter(requestWrapper,response);
        log.info(requestWrapper.getBody());
    }

    @Override
    public void destroy() {
    }

}
