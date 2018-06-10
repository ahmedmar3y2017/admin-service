package com.example.demo.WebService;

import com.example.demo.ServiceImpl.BrandServiceImpl;
import com.example.demo.entities.Brands;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ahmed on 2/1/2018.
 */
// basic Url
//http://localhost:8080
@RestController
@RequestMapping("/rest")
public class BrandRest {
    @Autowired
    BrandServiceImpl brandService;

    // insert
    @ApiOperation(value = "View a list of available Brand", response = Brands.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Added "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 204, message = "Not Countent Found"),
            @ApiResponse(code = 400, message = "bad Request please Fill All parameters ")
    }
    )
    @RequestMapping(value = "/brand", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> insert(@RequestBody Brands brands) {
        if (brands == null) {
            return new ResponseEntity<String>("Please add Brand details !!", HttpStatus.NO_CONTENT);

        }
        Brands b = brandService.saveBrands(brands);

        return new ResponseEntity<Brands>(b, HttpStatus.CREATED);

    }


    //getById
    @ApiOperation(value = "View available Brand", response = Brands.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/brand/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Getspecific(@PathVariable("id") int id) {

        Brands brands = brandService.getBrandsById(id);
        if (brands == null) {
            return new ResponseEntity<String>("Brand Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<Brands>(brands, HttpStatus.OK);

        }


    }

    // getAll
    @ApiOperation(value = "View a list of available Brands", response = Brands.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/brand", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAll() {
        List<Brands> brands = brandService.getAll();
        if (brands.size() == 0) {
            return new ResponseEntity<String>("Brand Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<Brands>>(brands, HttpStatus.OK);

        }


    }


    // Update
    @ApiOperation(value = "Update Avaliable Brands", response = Brands.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Updated "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/brand", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Update(@RequestBody Brands cat) {

        Brands brands = brandService.updateBrands(cat);
        if (brands == null) {
            return new ResponseEntity<String>("Brands Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<Brands>(brands, HttpStatus.OK);

        }
    }

    // Delete Brand From System
    @ApiOperation(value = "Delete Available Brand", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/brand/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteBrand(@PathVariable("id") int id) {
        int result = brandService.deleteBrandsByAvailable(id);
        if (result == 0) {
            return new ResponseEntity<String>("Brand Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<String>("Done Delete Brand ", HttpStatus.OK);

        }

    }


}
