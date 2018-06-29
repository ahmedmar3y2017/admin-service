package com.example.demo.WebService;


import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.Jedis;


@RestController
public class LoginRest {


    @RequestMapping("/token")
    public Map<String, String> token(HttpSession session, HttpServletRequest request) {
        System.out.println(request.getRemoteHost());
        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(remoteHost+":"+portNumber);
        System.out.println(request.getRemoteAddr());
        System.out.println("token"+session.getId());
        return Collections.singletonMap("token", session.getId());
    }

    @RequestMapping("/checkSession")
    public ResponseEntity checkSession() {
        return new ResponseEntity("Session Active!", HttpStatus.OK);
    }

//    @RequestMapping(value="/user/logout", method= RequestMethod.POST)
//    public ResponseEntity logoutDo(Jedis j){
//        //SecurityContextHolder.clearContext();
////list all keys in redis
//        //Set<String> redisResult =  jedis.keys("*");
//        //List<String> list = new ArrayList<>(redisResult);
////delete key by string
//        //jedis.del(list.get(0));
//// if we want remove all
//        j.flushAll();
//
//        return new ResponseEntity("Logout Successfully!", HttpStatus.OK);
//    }

}