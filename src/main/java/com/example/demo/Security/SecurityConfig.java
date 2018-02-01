//package com.example.demo.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Created by ahmed on 1/31/2018.
// */
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//
//
//        http.csrf().disable().authorizeRequests().antMatchers("/rest/business/**").hasAnyRole("admin").and().formLogin();
//    }
//
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.inMemoryAuthentication().withUser("ahmed").password("pass").roles("user", "admin");
//        auth.inMemoryAuthentication().withUser("mohamed").password("pass").roles("user");
//
//    }
//
//
//}
