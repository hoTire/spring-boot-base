package com.googlecode.hotire.base.method.support;

import com.googlecode.hotire.base.annotation.BaseSession;
import com.googlecode.hotire.base.domain.Account;
import com.googlecode.hotire.base.domain.BaseSessionInfo;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class BaseSessionArgumentResolver implements HandlerMethodArgumentResolver {
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return (parameter.hasParameterAnnotation(BaseSession.class) && parameter.getParameterType().equals(BaseSessionInfo.class));
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    try {
      return ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getBaseSessionInfo();
    } catch (Exception e) {
      return null;
    }
  }
}
