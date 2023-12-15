package com.example.springaopdemo;

import com.example.springaopdemo.dao.AccountDAO;
import com.example.springaopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringaopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringaopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
            demoBeforeAdvice(accountDAO, membershipDAO);
        };
    }

    private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        accountDAO.addAccount();
        System.out.println("Calling membership addAccount");
        membershipDAO.addAccount();
    }

}
