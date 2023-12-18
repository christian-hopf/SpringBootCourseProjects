package com.example.restcruddatabasedemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.restcruddatabasedemo.controller.*.*(..))")
    private void controllerPackage() {
    }

    @Pointcut("execution(* com.example.restcruddatabasedemo.dao.*.*(..))")
    private void daoPackage() {
    }

    @Pointcut("execution(* com.example.restcruddatabasedemo.service.*.*(..))")
    private void servicePackage() {
    }

    @Pointcut("controllerPackage() || daoPackage() || servicePackage()")
    private void forApp() {
    }

    @Before("forApp()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("EXECUTING @Before advice in method: " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        logger.info("METHOD ARGS:");
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

    @AfterReturning(pointcut = "forApp()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        logger.info("EXECUTING @AfterReturning advice in method: " + joinPoint.getSignature());
        logger.info("RESULT: " + result);
    }
}
