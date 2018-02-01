package com.example.demo;

import java.util.Date;

//import com.example.demo.Swagger.SwaggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImpl.AdminServiceImpl;
import com.example.demo.ServiceImpl.BusinessServiceImpl;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Business;

@RestController
@SpringBootApplication
//@ComponentScan(basePackageClasses = {
//		SwaggerConfig.class
//})

public class AdminServiceApplication implements CommandLineRunner {
	@Autowired
	BusinessServiceImpl businessServiceImpl;
	@Autowired
	AdminServiceImpl adminServiceImpl;

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AdminServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);

		// ahmed
		// LOGGER.error("Message logged at ERROR level");
		// LOGGER.warn("Message logged at WARN level");
		// LOGGER.info("Message logged at INFO level");
		// LOGGER.debug("Message logged at DEBUG level");

	}

	@CrossOrigin
	@RequestMapping("/")
	public String welcome() {
		String name = "kk";
		// if (name.length() == 2) {
		// throw new RuntimeException("Opps exception has occured");
		// }
		return "Hello World!!";
	}

	@Override
	public void run(String... args) throws Exception {
		// ------------------- business --------------------
		// insert
		// businessServiceImpl.saveBusiness(createBusiness());
		// update
		// businessServiceImpl.updateBusiness(1, createBusiness());
		// delete
		// System.out.println(businessServiceImpl.deleteBusinessById(1));
		// getById
		// System.out.println(businessServiceImpl.getBusinessById(1).getAdmins());
		// -------------------- admin -----------------------
		// insert
		// adminServiceImpl.saveAdmin(createAdmin());
		// update
		// adminServiceImpl.updateAdmin(1, createAdmin());
		// delete
		// adminServiceImpl.deleteAdminById(1);
		// getById
		// System.out.println(adminServiceImpl.getAdminById(2).getEmail());
		// ------------------- ------------------------------------
		// System.out.println(businessimpl.findById(1).getEmail());

		System.out.println("Done ya man ");
	}

	private Business createBusiness() {

		Business business = new Business("eslam", "123", "logooo", "123456789", "ahmedtttt@gmail.com", "tanta", "tanta",
				"tant", "tantaaa", 123, "url", "desc", "notes", "paypal", 0);

		return business;
	}

	private Admin createAdmin() {
		Business business = createBusiness();
		business.setId(1);
		Admin admin = new Admin(business, "level1", "ahmed", "mohamed", "mohamedeslam@gmail.com", "123456", 123, 123,
				"address1", "address2", "city", "state", "country", 123456, new Date(), new Date());
		return admin;

	}
}
