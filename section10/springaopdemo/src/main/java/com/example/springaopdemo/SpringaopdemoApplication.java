package com.example.springaopdemo;

import com.example.springaopdemo.dao.AccountDAO;
import com.example.springaopdemo.dao.MembershipDAO;
import com.example.springaopdemo.service.FortuneService;
import com.example.springaopdemo.service.FortuneServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringaopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringaopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, FortuneService fortuneService) {
        return runner -> {
//            demoBeforeAdvice(accountDAO, membershipDAO);
//            demoAfterReturningAdvice(accountDAO);
//            demoAfterThrowingAdvice(accountDAO);
//            demoAfterFinallyAdvice(accountDAO);
//            demoAroundAdvice(fortuneService);
//            demoAroundAdviceHandlingException(fortuneService);
            demoAroundAdviceRethrowException(fortuneService);
        };
    }

    private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        System.out.println("Calling account addAccount");
        Account account1 = new Account();
        account1.setName("Laptop");
        account1.setLevel("10");
        accountDAO.addAccount(account1, false);
        System.out.println("Calling membership addMembership");
        membershipDAO.addMembership();

        System.out.println("Calling setter methods");
        accountDAO.setName("Christian");
        accountDAO.setZipCode(11111);
        System.out.println("Calling getter methods");
        accountDAO.getName();
        accountDAO.getZipCode();
//        System.out.println("Calling addAccountInt");
//        accountDAO.addAccountInt();
//        System.out.println("Calling account doNothing");
//        accountDAO.doNothing();
//        System.out.println("Calling membership greetMember");
//        membershipDAO.greetMember();
    }

    private void demoAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("Displaying accounts");
        System.out.println(accounts);
    }

    private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
        try {
            List<Account> accounts = accountDAO.findAccounts();
        } catch (Exception e) {
            System.out.println("Exception in findAccounts(): " + e);
        }
    }

    private void demoAfterFinallyAdvice(AccountDAO accountDAO) {
        try {
            List<Account> accounts = accountDAO.findAccounts();
        } catch (Exception e) {
            System.out.println("Exception in findAccounts(): " + e);
        }
    }

    private void demoAroundAdvice(FortuneService fortuneService) throws InterruptedException {
        System.out.println("Calling getFortune()");
        String result = fortuneService.getFortune();
        System.out.println("Your fortune: " + result);
    }

    private void demoAroundAdviceHandlingException(FortuneService fortuneService) {
        System.out.println("Calling getFortune() in method demoAroundAdviceHandlingExceptions()");
        boolean flag = true;
        String result = fortuneService.getFortune(flag);
        System.out.println("Your fortune: " + result);
    }

    private void demoAroundAdviceRethrowException(FortuneService fortuneService) {
        System.out.println("Calling getFortune() in method demoAroundAdviceRethrowException()");
        boolean flag = true;
        String result = fortuneService.getFortune(flag);
        System.out.println("Your fortune: " + result);
    }

}
