package com.example.demo.WebService;

import com.example.demo.ServiceImpl.BusinessServiceImpl;
import com.example.demo.entities.Business;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImpl.AdminServiceImpl;
import com.example.demo.entities.Admin;

import java.util.Set;

// basic Url
//http://localhost:8080
@RestController
@RequestMapping("/rest")
public class AdminRest {
    @Autowired
    AdminServiceImpl adminServiceImpl;
    @Autowired
    BusinessServiceImpl businessServiceImpl;

    // insert
    @ApiOperation(value = "View a list of available Admin to specific Business", response = Admin.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Added "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 204, message = "Not Countent Found"),
            @ApiResponse(code = 400, message = "bad Request please Fill All parameters ")
    }
    )
    @RequestMapping(value = "/business/{id}/admin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> insert(@PathVariable("id") int Businessid, @RequestBody Admin admin) {
        if (admin == null) {
            return new ResponseEntity<String>("Please add Business details !!", HttpStatus.NO_CONTENT);

        }

        // check email , password
        if (admin.getEmail() == "" || admin.getPassword() == "") {

            return new ResponseEntity<String>("Please provide the Email and password", HttpStatus.BAD_REQUEST);

        }
        // encrypt password before insert Admin
        admin.setBusiness(new Business(Businessid));

        Admin a = adminServiceImpl.saveAdmin(admin);

        return new ResponseEntity<Admin>(a, HttpStatus.CREATED);

    }


    // getAll
    @ApiOperation(value = "View a list of available All Admin By BusinessId", response = Admin.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{businessid}/admin", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAll(@PathVariable("businessid") int businessid) {
        Business business = businessServiceImpl.getBusinessById(businessid);
        if (business == null) {
            return new ResponseEntity<String>("Business Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {

            return new ResponseEntity<Set<Admin>>(business.getAdmins(), HttpStatus.OK);

        }


    }

    // getById
    @ApiOperation(value = "View available Admin", response = Admin.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{businessid}/admin/{adminid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Getspecific(@PathVariable("businessid") int businessid, @PathVariable("adminid") int adminid) {

        Business business = businessServiceImpl.getBusinessById(businessid);
        if (business == null) {

            return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);
        } else {
            Admin admin = business.getAdmins().stream()
                    .filter(x -> adminid == x.getId())
                    .findAny()
                    .orElse(null);

            if (admin == null) {
                return new ResponseEntity<String>("Admin Not Found !!", HttpStatus.NOT_FOUND);

            } else {
                return new ResponseEntity<Admin>(admin, HttpStatus.OK);

            }
        }

    }

    // Update
    @ApiOperation(value = "Update Avaliable Admin", response = Admin.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Updated "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{businessid}/admin/{adminid}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> UpdateAdmin(@PathVariable("businessid") int businessid, @PathVariable("adminid") int adminid, @RequestBody Admin admin) {


        Business business = businessServiceImpl.getBusinessById(businessid);
        if (business == null) {

            return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);
        } else {


            Admin aadmin = adminServiceImpl.updateAdmin(adminid, admin);
            if (aadmin == null) {
                return new ResponseEntity<String>("Admin Not Found !!", HttpStatus.NOT_FOUND);

            } else {
                return new ResponseEntity<Admin>(aadmin, HttpStatus.OK);

            }
        }


    }

    // Delete
    @ApiOperation(value = "Delete Available Admin", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{businessid}/admin/{adminid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteTopic(@PathVariable("businessid") int businessid, @PathVariable("adminid") int adminid) {

        Business business = businessServiceImpl.getBusinessById(businessid);
        if (business == null) {

            return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);
        } else {
            int result = adminServiceImpl.deleteAdminById(adminid);
            if (result == 0) {
                return new ResponseEntity<String>("Admin Not Found !!", HttpStatus.NOT_FOUND);

            } else {
                return new ResponseEntity<String>("Done Delete Admin ", HttpStatus.OK);

            }


        }


    }
}
