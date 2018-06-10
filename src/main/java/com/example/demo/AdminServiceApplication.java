package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//import com.example.demo.Swagger.SwaggerConfig;
import com.example.demo.MailConfig.EmailServiceImpl;
import com.example.demo.ServiceImpl.ProductServiceImpl;
import com.example.demo.storage.StorageService;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImpl.AdminServiceImpl;
import com.example.demo.ServiceImpl.BusinessServiceImpl;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Business;

import javax.annotation.Resource;

@RestController
@SpringBootApplication
//@EnableResourceServer
@EnableCaching


public class AdminServiceApplication implements CommandLineRunner {
    // -------- new Updated  --------

    @Resource
    StorageService storageService;

    @Autowired
    BusinessServiceImpl businessService;
    @Autowired
    AdminServiceImpl adminService;

//    @Autowired
//    public EmailServiceImpl emailService;
//    @Autowired
//    public SimpleMailMessage template;

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AdminServiceApplication.class, args);

        String[] beaStrings = configurableApplicationContext.getBeanDefinitionNames();
        // to print all beans
        System.err.println("********** All Beans ***************** ");
//        Arrays.stream(beaStrings).sorted().forEach(x -> System.out.println(x));
        System.out.println("*******************************");

    }

    // ------------------  start Service -----------------------------
//    @CrossOrigin
//    @RequestMapping(value = {"/"})
//    public String welcome() {
//
//        return "Done";
//    }


    // on run App
    @Override
    public void run(String... args) throws Exception {


/*
*
* String name, String password, String logo, String contact, String email, String address,
                    String city, String state, String country, Integer postalCode, String url, String description, String notes,
                    String paymentMethods, Integer active, boolean available
* */

        /*


         *Business business, String adminLevel, String firstName, String lastName, String email, String password,
                 Integer active, Integer phone, String address1, String address2, String city, String state, String country,
                 Integer postalCode, Date lastActive, Date registerDate, boolean available
         *
         * */
        int siz = businessService.getAll().size();
        if (siz <= 0) {
            Business business = businessService.saveBusiness(new Business("admin", "$2a$10$vuVscYda3P7lH4gdGvkLbuPIM7X7TfGZBeV/yjjjeP5sp86yY7kKK", "logo", "123123", "ahmedmohamedmar3y2017@gmail.com",
                    "tanta", "tanta", "egypt", "kafr elzayat", 123, "url", "desc", "notes", "paypal", 1, true));


            adminService.saveAdmin(new Admin(business, "level1", "ahmed", "mar3y", "ahmedmohamedmar3y2017@gmail.com", "$2a$10$vuVscYda3P7lH4gdGvkLbuPIM7X7TfGZBeV/yjjjeP5sp86yY7kKK", 1, "01201288779", "address1", "address 2 ", "tanta", "Egypt", "country", 1234,
                    new Date(), new Date(), "admin", "ADMIN", true));

        }
//        storageService.deleteAll();
//        storageService.init();


//        else {
//            Business business = businessService.getAll().get(0);
//            adminService.saveAdmin(new Admin(business, "level1", "ahmed", "mar3y", "ahmedmohamedmar3@gmail.com", "$2a$10$vuVscYda3P7lH4gdGvkLbuPIM7X7TfGZBeV/yjjjeP5sp86yY7kKK", 1, "012088779", "address1", "address 2 ", "tanta", "Egypt", "country", 1234,
//                    new Date(), new Date(), "adminadmin", "ADMIN", true));
//
//        }
//        emailService.sendSimpleMessage("ahmedmar3y108108@gmail.com", "BusinessIn App" ,"BusinessIn App");

//        emailService.sendSimpleMessageUsingTemplate("ahmedmar3y108@gmail.com", "BusinessIn App Subject", template, "BusinessIn App args");

//emailService.sendMessageWithAttachment("ahmedmar3y108@gmail.com","ahmed","<h1>ahmed mar3y<h1>","");
//        System.err.println("Done ya man ");
    }

}
