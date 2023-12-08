package com.example.restcrudsecuritydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails christian = User.builder()
//                .username("christian")
//                .password("{noop}password")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails manager = User.builder()
//                .username("manager")
//                .password("{noop}password")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}password")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(christian, manager, admin);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/rest/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "rest/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/rest/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/rest/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/rest/employees/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
