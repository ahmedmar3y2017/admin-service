//package com.example.demo.Security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * Created by ahmed mar3y on 04/02/2018.
// */
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//
//@EnableResourceServer
//@Configuration
//public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        http.requestMatchers()
////                .antMatchers("/login", "/oauth/authorize")
////                .and()
////                .authorizeRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .permitAll();
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/rest/**").authenticated();
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.parentAuthenticationManager(authenticationManager)
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
//                .roles("ADMIN");
//    }
//}