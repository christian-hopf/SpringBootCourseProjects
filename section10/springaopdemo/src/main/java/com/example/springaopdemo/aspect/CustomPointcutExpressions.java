package com.example.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CustomPointcutExpressions {

    @Pointcut("execution(* com.example.springaopdemo.dao.*.*(..))")
    public void daoPackage() {
    }

    @Pointcut("execution(* com.example.springaopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.example.springaopdemo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("daoPackage() && !(getter() || setter())")
    public void daoPackageNotGetterSetter() {
    }
}
