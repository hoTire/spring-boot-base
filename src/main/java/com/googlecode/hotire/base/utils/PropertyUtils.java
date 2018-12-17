package com.googlecode.hotire.base.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PropertyUtils implements InitializingBean {
  @Value("{app.name}")
  private String appName;

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("app name : " + appName);
  }
}
