package com.example.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AnalyticsAspect {
    @Before("com.example.springaopdemo.aspect.CustomPointcutExpressions.daoPackageNotGetterSetter()")
    public void performAnalytics() {
        System.out.println("EXECUTING @Before ADVICE ORDER 2");
    }
}
