package com.example.demo.WebService;

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

@RestController
@RequestMapping("/rest")
public class AdminRest {
	@Autowired
	AdminServiceImpl adminServiceImpl;

	// insert
	@RequestMapping(value = "/admin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insert(@RequestBody Admin admin) {
		if (admin == null) {
			return new ResponseEntity<String>("Please add Business details !!", HttpStatus.NO_CONTENT);

		}

		// check email , password
		if (admin.getEmail() == "" || admin.getPassword() == "") {

			return new ResponseEntity<String>("Please provide the Email and password", HttpStatus.BAD_REQUEST);

		}
		// encrypt password before insert Admin
		Admin a = adminServiceImpl.saveAdmin(admin);

		return new ResponseEntity<Admin>(a, HttpStatus.CREATED);

	}

	// getById
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> Getspecific(@PathVariable("id") String id) {

		Admin admin = adminServiceImpl.getAdminById(Integer.parseInt(id));
		if (admin == null) {
			return new ResponseEntity<String>("Admin Not Found !!", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);

		}

	}

	// Update
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> UpdateTopic(@RequestBody Admin admin, @PathVariable("id") String id) {

		Admin aadmin = adminServiceImpl.updateAdmin(Integer.parseInt(id), admin);
		if (aadmin == null) {
			return new ResponseEntity<String>("Admin Not Found !!", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<Admin>(aadmin, HttpStatus.OK);

		}
	}

	// Delete
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> DeleteTopic(@PathVariable("id") String id) {
		int result = adminServiceImpl.deleteAdminById(Integer.parseInt(id));
		if (result == 0) {
			return new ResponseEntity<String>("Admin Not Found !!", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<String>("Done Delete Admin ", HttpStatus.OK);

		}

	}
}
