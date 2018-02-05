//package com.example.demo.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * Created by ahmed mar3y on 04/02/2018.
// */
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserService userService;
//
//    @Autowired
//    public CustomUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return this.userService.findByEmail(email);
//    }
//}
