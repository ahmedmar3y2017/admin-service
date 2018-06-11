package com.example.demo.WebService;

import com.example.demo.ServiceImpl.customerServiceImpl;
import com.example.demo.entities.Customers;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// basic Url
//http://localhost:8080
@RestController
@RequestMapping("/rest")
public class customerRest {

    @Autowired
    customerServiceImpl customerService;








}
