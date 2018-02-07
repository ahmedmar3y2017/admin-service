package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//import com.example.demo.Swagger.SwaggerConfig;
import com.example.demo.ServiceImpl.ProductServiceImpl;
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
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImpl.AdminServiceImpl;
import com.example.demo.ServiceImpl.BusinessServiceImpl;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Business;

@RestController
@SpringBootApplication
//@EnableResourceServer
@EnableCaching


public class AdminServiceApplication implements CommandLineRunner {


    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AdminServiceApplication.class, args);

        String[] beaStrings = configurableApplicationContext.getBeanDefinitionNames();
        // to print all beans
        System.err.println("********** All Beans ***************** ");
//        Arrays.stream(beaStrings).sorted().forEach(x -> System.out.println(x));
        System.out.println("*******************************");

    }

    @CrossOrigin
    @RequestMapping(value = {"/"})
    public String welcome() {

        return "Done";
    }

    // ------------- Bean For Cach ------------------------
    // simple
//    @Bean
//    public CacheManager cacheManager(){
//        return new ConcurrentMapCacheManager("businessCache" );
//    }
    // guava
    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(24, TimeUnit.HOURS));
        cacheManager.setCacheNames(Arrays.asList("businessCache"));
        return cacheManager;
    }


    // on run App
    @Override
    public void run(String... args) throws Exception {
//        System.err.println("Done ya man ");
    }

}
