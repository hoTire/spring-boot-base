package com.googlecode.hotire.base.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class BaseAspect {
    /**
     * ordering AOP
     */
    @Aspect
    @Component
    @Order(1)
    public class test1 {
        @Before("execution(* com.googlecode.hotire.base.controller.BaseController.testAOP(..))")
        public void testAOP(JoinPoint joinPoint) {
            Object[] args = joinPoint.getArgs();
            log.info("test AOP 1 ");
        }
    }
    @Aspect
    @Component
    @Order(2)
    public class test2 {
        @Before("execution(* com.googlecode.hotire.base.controller.BaseController.testAOP(..))")
        public void testAOP2(JoinPoint joinPoint) {
            Object[] args = joinPoint.getArgs();
            log.info("test AOP 2 ");
        }
    }
}
