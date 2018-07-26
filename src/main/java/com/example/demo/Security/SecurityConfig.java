package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

/**
 * Created by ahmed on 1/31/2018.
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AdminDetailServiceImpl adminDetailService;
//    @Autowired
//    AuthenticationEntryPoint authenticationEntryPoint;
private static final String[] PUBLIC_MATCHERS = {
        "/css/**",
        "/js/**",
        "/image/**",
};

    private BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtility.passwordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
//        auth.inMemoryAuthentication().withUser("ahmed").password("pass").roles("user", "admin");
//        auth.inMemoryAuthentication().withUser("mohamed").password("pass").roles("user");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(adminDetailService).passwordEncoder(passwordEncoder());
    }

    //it invoke when create new session should assign new session id
    @Bean
    public HeaderHttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }



}
