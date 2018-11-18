package com.googlecode.hotire.base.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BaseListener {

  public BaseListener(ApplicationArguments arguments) {
    log.info("test exist : " + arguments.containsOption("test"));
  }
}
