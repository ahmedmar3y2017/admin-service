package com.example.demo.WebService;

import com.example.demo.ServiceImpl.BrandServiceImpl;
import com.example.demo.ServiceImpl.BusinessServiceImpl;
import com.example.demo.ServiceImpl.CategoryServiceImpl;
import com.example.demo.ServiceImpl.ProductServiceImpl;
import com.example.demo.entities.Brands;
import com.example.demo.entities.Business;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by ahmed on 2/2/2018.
 */
// basic Url
//http://localhost:8080
@RestController
@RequestMapping("/rest")
public class ProductRest {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    BusinessServiceImpl businessServiceImpl;
    @Autowired
    BrandServiceImpl brandService;
    @Autowired
    CategoryServiceImpl categoryService;


    // --------------------------------- Insert Method -----------------------------
    //-------------------------- not completed ---------------------------
    // insert
    @ApiOperation(value = "Insert Product ", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Added "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 204, message = "Not Countent Found"),
            @ApiResponse(code = 400, message = "bad Request please Fill All parameters ")
    }
    )
    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> insert(
            @RequestParam(required = true, name = "category", defaultValue = "0") int categoryId,
            @RequestParam(required = true, name = "brand", defaultValue = "0") int brandId,
            @RequestParam(required = true, name = "business") int businessId,
            @RequestBody Product product) {
        if (product == null) {
            return new ResponseEntity<String>("Please add Product details !!", HttpStatus.NO_CONTENT);

        }
        if (businessId != 0) {

            // check if Category and business and brand id found in database
            if (categoryService.getCategoryById(categoryId) != null && businessServiceImpl.getBusinessById(businessId) != null && brandService.getBrandsById(brandId) != null) {
                // add this product

                product.setBrands(new Brands(brandId));
                product.setCategory(new Category(categoryId));
                product.setBusiness(new Business(businessId));

                Product a = productService.saveProduct(product);

                return new ResponseEntity<Product>(a, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<String>("Parameters Not Exist in server ", HttpStatus.NO_CONTENT);

            }


        } else {
            // if businessId Not Found
            return new ResponseEntity<String>("BusinessId Required ..", HttpStatus.BAD_REQUEST);


        }
    }


    // -------------------------------- Get Methods ----------------------------------------

    // getAll
    @ApiOperation(value = "View a list of available Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/product", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAll() {
        List<Product> products = productService.getAll();
        if (products.size() == 0) {
            return new ResponseEntity<String>("Product Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

        }


    }

    // getAll By Business
    @ApiOperation(value = "View a list of available Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{categoryid}/product", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAllByBusiness(@PathVariable("categoryid") int businessid) {

        // check Business Exists
        Business business = businessServiceImpl.getBusinessById(businessid);
        if (business == null) {
            return new ResponseEntity<String>("business Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            Set<Product> products = business.getProducts();
            if (products.size() == 0) {
                return new ResponseEntity<String>("Product Not Found !!",
                        HttpStatus.NOT_FOUND);

            } else {
                return new ResponseEntity<Set<Product>>(products, HttpStatus.OK);

            }
        }


    }

    // getAll By Category
    @ApiOperation(value = "View a list of available Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/category/{categoryid}/product", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAllByCategory(@PathVariable("categoryid") int categoryid) {

        // check Category Exists
        Category category = categoryService.getCategoryById(categoryid);
        if (category == null) {
            return new ResponseEntity<String>("Category Not Found !!",
                    HttpStatus.NOT_FOUND);
        } else {
            List<Product> products = category.getProducts();
            if (products.size() == 0) {
                return new ResponseEntity<String>("Product Not Found !!",
                        HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

            }
        }
    }

    // getAll By Brand
    @ApiOperation(value = "View a list of available Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/brand/{brandid}/product", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAllByBrand(@PathVariable("brandid") int brandid) {

        // check brand exists
        Brands brands = brandService.getBrandsById(brandid);
        if (brands == null) {
            return new ResponseEntity<String>("Brand Not Found !!",
                    HttpStatus.NOT_FOUND);
        } else {
            Set<Product> products = brands.getProducts();
            if (products.size() == 0) {
                return new ResponseEntity<String>("Product Not Found !!",
                        HttpStatus.NOT_FOUND);

            } else {
                return new ResponseEntity<Set<Product>>(products, HttpStatus.OK);

            }
        }


    }

    // -------------------------  Update Methods --------------------------------

    @ApiOperation(value = "Update Avaliable Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Updated "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{businessid}/product/{productid}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> Updateproduct(@PathVariable("businessid") int businessid, @PathVariable("productid") int productid, @RequestBody Product product) {
        Business business = businessServiceImpl.getBusinessById(businessid);
        if (business == null) {

            return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);
        } else {


            Product product1 = productService.updateProduct(productid, product);
            if (product1 == null) {
                return new ResponseEntity<String>("Product Not Found !!", HttpStatus.NOT_FOUND);

            } else {
                return new ResponseEntity<Product>(product1, HttpStatus.OK);

            }
        }


    }


    // --------------------------- Delete Methods --------------------------------------
    // Delete Product From System
    @ApiOperation(value = "Delete Available product", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteProduct(@PathVariable("id") int id) {
        int result = productService.deleteProductById(id);
        if (result == 0) {
            return new ResponseEntity<String>("Product Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<String>("Done Delete Product ", HttpStatus.OK);

        }

    }

    // delete by businessId
    @ApiOperation(value = "Delete Available product By Business ..", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/business/{categoryid}/product", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteProductByBusiness(@PathVariable("categoryid") int businessid) {
        int result = productService.deleteProductByBusinessId(businessid);
        if (result == 0) {
            return new ResponseEntity<String>("Product For Business ( " + businessid + " ) Not Found !!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<String>("Done Delete Product ", HttpStatus.OK);
        }
    }

    // delete by Category
    @ApiOperation(value = "Delete Available product By category ..", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted "),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/category/{categoryid}/product", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteProductByCategory(@PathVariable("categoryid") int categoryid) {
        int result = productService.deleteProductByCategoryId(categoryid);
        if (result == 0) {
            return new ResponseEntity<String>("Product For Category ( " + categoryid + " ) Not Found !!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<String>("Done Delete Product ", HttpStatus.OK);
        }
    }


}
