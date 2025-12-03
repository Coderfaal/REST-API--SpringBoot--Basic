package com.spring.restfulapi.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//import com.spring.restfulapi.entity.Loan;



//@Aspect
@Component
@Slf4j         // lombok annotation for logging
public class ResourceInterceptAspect {


    @Pointcut("execution(  * com.spring.restfulapi.controller.*.*(..))")
    public void loggingPointCut() { }


    @Before("loggingPointCut()") // @Before means before advice
    public void before(JoinPoint joinPoint) {

        log.info("Before method invoked :: " + joinPoint.getSignature());

    }

    @After("loggingPointCut()") // @After means after advice
    public void  after(JoinPoint joinPoint) {

        log.info("After method invoked :: " + joinPoint.getSignature());

    }
}
