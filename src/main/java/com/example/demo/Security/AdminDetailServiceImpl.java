package com.example.demo.Security;

import com.example.demo.ServiceImpl.AdminServiceImpl;
import com.example.demo.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by ahmed mar3y on 05/02/2018.
 */
@Service
public class AdminDetailServiceImpl implements UserDetailsService {
    @Autowired
    AdminServiceImpl adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.getAdminByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(admin.getRole());
        System.out.println(admin.getRole());
        System.out.println(authority.getAuthority());
        User user = new User(admin.getUsername(), admin.getPassword(), Arrays.asList(authority));
        System.out.println(user.getUsername() + " \t  " + user.getPassword() +"\t"+ user.getAuthorities());
        UserDetails userDetails = (UserDetails) user;

        return userDetails;
    }
}
