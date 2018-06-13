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

import java.util.List;

// basic Url
//http://localhost:8080
@RestController
@RequestMapping("/rest")
public class customerRest {

    @Autowired
    customerServiceImpl customerService;


    // insert
    @ApiOperation(value = "View a list of available Customers", response = Customers.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Added "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 204, message = "Not Countent Found"),
            @ApiResponse(code = 400, message = "bad Request please Fill All parameters ")
    }
    )
    @RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> insert(@RequestBody Customers customer) {
        if (customer == null) {
            return new ResponseEntity<String>("Please add Customers details !!", HttpStatus.NO_CONTENT);
        }
        Customers b = customerService.saveCustomers(customer);
        return new ResponseEntity<Customers>(b, HttpStatus.CREATED);


    }

    // getById
    @ApiOperation(value = "View available Customers", response = Customers.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Getspecific(@PathVariable("id") String id) {

        Customers customer = customerService.getCustomersById(Integer.parseInt(id));
        if (customer == null) {
            return new ResponseEntity<String>("Customers Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<Customers>(customer, HttpStatus.OK);

        }


    }


    // getAll
    @ApiOperation(value = "View a list of available Customers", response = Customers.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/customer", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAll() {
        List<Customers> customer = customerService.getAll();
        if (customer.size() == 0) {
            return new ResponseEntity<String>("Customers Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<Customers>>(customer, HttpStatus.OK);

        }


    }


}
