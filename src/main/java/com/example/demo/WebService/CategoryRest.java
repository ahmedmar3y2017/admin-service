package com.example.demo.WebService;

import com.example.demo.ServiceImpl.CategoryServiceImpl;
import com.example.demo.entities.Business;
import com.example.demo.entities.Category;
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
 * Created by ahmed on 1/31/2018.
 */
// basic Url
//http://localhost:8080
@RestController
@RequestMapping("/rest")
public class CategoryRest {
    @Autowired
    CategoryServiceImpl categoryService;


    // insert
    @ApiOperation(value = "View a list of available Category", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Added "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 204, message = "Not Countent Found"),
            @ApiResponse(code = 400, message = "bad Request please Fill All parameters ")
    }
    )
    @RequestMapping(value = "/category", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> insert(@RequestParam(required = false, name = "parentid", defaultValue = "0") int parentid,
                                    @RequestBody Category category) {
        if (category == null) {
            return new ResponseEntity<String>("Please add Category details !!", HttpStatus.NO_CONTENT);
        } else {
            // this is category is sub category
            if (parentid != 0) {
                // check parent id first
                Category category1 = categoryService.getCategoryById(parentid);
                if (category1 == null) {
                    return new ResponseEntity<String>("Parent category Not Found  !!", HttpStatus.NOT_FOUND);
                } else {
                    // parent id that will added
                    Category cc = new Category();
                    cc.setId(parentid);
//                 add parent id
                    category.setParentId(cc);
                    Category b = categoryService.saveCategory(category);
                    return new ResponseEntity<Category>(b, HttpStatus.CREATED);
                }
            }
            // this is category is main category
            else {
                Category b = categoryService.saveCategory(category);
                return new ResponseEntity<Category>(b, HttpStatus.CREATED);
            }
        }
    }


    //getById
    @ApiOperation(value = "View available Category", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Getspecific(@PathVariable("id") int id) {

        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity<String>("Category Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<Category>(category, HttpStatus.OK);

        }


    }

    // getAll
    @ApiOperation(value = "View a list of available Business", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/category", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAll() {
        List<Category> categories = categoryService.getAll();
        if (categories.size() == 0) {
            return new ResponseEntity<String>("Category Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);

        }


    }

    // Update
    @ApiOperation(value = "Update Avaliable Category", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Updated "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Update(@RequestBody Category cat, @PathVariable("id") int id) {

        Category category = categoryService.updateCategory(id, cat);
        if (category == null) {
            return new ResponseEntity<String>("Category Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<Category>(category, HttpStatus.OK);

        }
    }

    // Delete Category From System
    @ApiOperation(value = "Delete Available Category", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteCategory(@PathVariable("id") int id) {
        int result = categoryService.deleteCategoryById(id);
        if (result == 0) {
            return new ResponseEntity<String>("Category Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<String>("Done Delete Category ", HttpStatus.OK);

        }

    }


}
