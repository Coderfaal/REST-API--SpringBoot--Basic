package com.spring.restfulapi.AOP;

import com.spring.restfulapi.entity.Loan;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j

//execution for methods
public class ResourceInterceptorAspect5 {

//designatores-this
    @Pointcut("this(com.spring.restfulapi.controller.LoanController)")
    public void loggingPointCut() {}

    @Around("loggingPointCut()")
    public Object around(ProceedingJoinPoint joinPoint)
            throws Throwable {

        log.info("Before method invoked :: "+ joinPoint.getSignature());
        log.info("Before method invoked :: "+ joinPoint.getArgs()[0]);

        Object object = joinPoint.proceed();

        if(object instanceof Loan) log.info("After method invoked.... "+
                joinPoint.getSignature());
        log.info("After method invoked :: "+ joinPoint.getArgs()[0]);
        return object;

    }
}
