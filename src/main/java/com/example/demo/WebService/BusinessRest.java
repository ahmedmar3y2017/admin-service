package com.example.demo.WebService;

import java.util.List;

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
public class BusinessRest {

	@Autowired
	BusinessServiceImpl businessServiceImpl;

	// insert
	@RequestMapping(value = "/business", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
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
	@RequestMapping(value = "/business/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

	// Update
	@RequestMapping(value = "/business/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> UpdateTopic(@RequestBody Business busines, @PathVariable("id") String id) {

		Business business = businessServiceImpl.updateBusiness(Integer.parseInt(id), busines);
		if (business == null) {
			return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<Business>(business, HttpStatus.OK);

		}
	}

	// Delete
	@RequestMapping(value = "/business/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> DeleteTopic(@PathVariable("id") String id) {
		int result = businessServiceImpl.deleteBusinessById(Integer.parseInt(id));
		if (result == 0) {
			return new ResponseEntity<String>("Business Not Found !!", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<String>("Done Delete Business ", HttpStatus.OK);

		}

	}

}
