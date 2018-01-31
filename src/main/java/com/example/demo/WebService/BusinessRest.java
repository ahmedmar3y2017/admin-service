package com.example.demo.WebService;

import java.util.List;

import com.example.demo.ServiceImpl.AdminServiceImpl;
import io.swagger.annotations.Api;
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

import com.example.demo.ServiceImpl.BusinessServiceImpl;
import com.example.demo.entities.Business;

// basic Url
//http://localhost:9091
@RestController
@RequestMapping("/rest")
@Api(value="BusinessIn Business")

public class BusinessRest {

	@Autowired
	BusinessServiceImpl businessServiceImpl;
	@Autowired
	AdminServiceImpl adminServiceImpl;
	// insert
	@ApiOperation(value = "View a list of available Business",response = Business.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully Added "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 204, message = "Not Countent Found") ,
			@ApiResponse(code = 400, message = "bad Request please Fill All parameters ")
	}
	)
	@RequestMapping(value = "/business", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE ,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> insert(@RequestBody Business busines) {
		if (busines == null) {
			return new ResponseEntity<String>("Please add Business details !!", HttpStatus.NO_CONTENT);

		}

		// check email , password
		if (busines.getEmail() == "" || busines.getPassword() == "") {

			return new ResponseEntity<String>("Please provide the Email and password", HttpStatus.BAD_REQUEST);

		}
		// encrypt password before insert Business
		Business b = businessServiceImpl.saveBusiness(busines);

		return new ResponseEntity<Business>(b, HttpStatus.CREATED);

	}

	// getById
	@ApiOperation(value = "View available Business",response = Business.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/business/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?>  Getspecific(@PathVariable("id") String id) {

		System.out.println(id);
		Business business = businessServiceImpl.getBusinessById(Integer.parseInt(id));
		System.out.println(business.getEmail());
		 if (business == null) {
		 return new ResponseEntity<String>("Business Not Found !!",
		 HttpStatus.NOT_FOUND);

		 } else {
		 return new ResponseEntity<Business>(business, HttpStatus.OK);

		 }


	}

	// getAll
	@ApiOperation(value = "View a list of available Business",response = Business.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/business", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?>  GetAll() {
		List<Business> business = businessServiceImpl.getAll();
		if (business.size()==0) {
			return new ResponseEntity<String>("Business Not Found !!",
					HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<List<Business>>(business, HttpStatus.OK);

		}


	}


	// Update
	@ApiOperation(value = "Update Avaliable Business",response = Business.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Updated "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/business/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> UpdateTopic(@RequestBody Business busines, @PathVariable("id") int id) {

		Business business = businessServiceImpl.updateBusiness(id, busines);
		if (business == null) {
			return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<Business>(business, HttpStatus.OK);

		}
	}

	// Delete Business Account From System
	@ApiOperation(value = "Delete Available Business",response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Deleted "),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/business/{id}", method = RequestMethod.DELETE , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> DeleteTopic(@PathVariable("id") int id) {
		// delete all admins and all products first by cascading option
		int result = businessServiceImpl.deleteBusinessById(id);
		if (result == 0) {
			return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<String>("Done Delete Business ", HttpStatus.OK);

		}

	}

}
