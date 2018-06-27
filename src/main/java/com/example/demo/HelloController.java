package com.example.demo;

/**
 * Created by ahmed mar3y on 07/02/2018.
 */

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HelloController {


    // check Device type and platform when login or sign up
    @RequestMapping("/")
    public String greeting(Device device) {
        String deviceType = "browser";
        String platform = "browser";

        if (device.isNormal()) {
            deviceType = "browser";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }

        platform = device.getDevicePlatform().name();

        if (platform.equalsIgnoreCase("UNKNOWN")) {
            platform = "browser";
        }

        System.err.println("Client Device Type: " + deviceType + ", Platform: " + platform);

        return "index";
    }


    // this is the login api/service
    @CrossOrigin
    @RequestMapping("/login")
    public Principal user(Principal principal) {
        return principal;
    }


}