package com.example.springaopdemo.aspect;

import com.example.springaopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    //    @Before("execution(public void com.example.springaopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.example.springaopdemo.Account, ..))")
//    @Before("execution(* add*(..))")
    @Before("com.example.springaopdemo.aspect.CustomPointcutExpressions.daoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("EXECUTING @Before ADVICE ORDER 1");
        System.out.println("Method signature: " + joinPoint.getSignature());
        System.out.println("Method args:");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                System.out.println(((Account) arg).getName());
                System.out.println(((Account) arg).getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.example.springaopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("EXECUTING @AfterReturning on method with signature: " + joinPoint.getSignature());
        System.out.println("Result: " + result);
        convertToUppercase(result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.springaopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("EXCEPTION IN @AfterThrowing: " + exception);
    }

    @After("execution(* com.example.springaopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("EXECUTING @After on method with signature: " + joinPoint.getSignature());
    }

    @Around("execution(* com.example.springaopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("EXECUTING @Around ADVICE");
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("@Around exception: " + e);
//            result = "Exception ignored. You will sleep well tonight";
            throw e;
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("DURATION: " + duration + " ms");
        return result;
    }

    private void convertToUppercase(List<Account> result) {
        for (Account acc : result) {
            acc.setName(acc.getName().toUpperCase(Locale.ROOT));
        }
    }
}