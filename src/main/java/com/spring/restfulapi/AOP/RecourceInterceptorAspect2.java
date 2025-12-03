package com.spring.restfulapi.AOP;

import com.spring.restfulapi.entity.Loan;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
//test only get methods with exceptions , get method returns only one object , test the sam emethod for exception
public class RecourceInterceptorAspect2 {

    @AfterReturning(value="execution( *com.spring.restfulapi.controller.*.*(..))"
            ,returning="product")

    public void afterRet(JoinPoint joinPoint, Loan loan) {

        log.info("After Returning method invoked :: "+loan);

    }

    @AfterThrowing
            (value="execution( * com.tcs.rest.resources .*.*(..))",throwing= "e")
    public void afterThrow(JoinPoint joinPoint, Exception e) {

        log.info("After method invoked :: "+e);

    }
}
