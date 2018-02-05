package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by ahmed on 1/31/2018.
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AdminDetailServiceImpl adminDetailService;
    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);


        http.csrf().disable().authorizeRequests().antMatchers("/rest/**").hasAnyRole("admin").and().httpBasic().realmName("Topic security application Realm")
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
//        auth.inMemoryAuthentication().withUser("ahmed").password("pass").roles("user", "admin");
//        auth.inMemoryAuthentication().withUser("mohamed").password("pass").roles("user");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(adminDetailService).passwordEncoder(bCryptPasswordEncoder);
    }


}
