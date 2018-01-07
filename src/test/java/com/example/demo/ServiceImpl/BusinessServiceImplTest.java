package com.example.demo.ServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DaoImpl.AdminDaoImpl;
import com.example.demo.DaoImpl.BusinessDaoImpl;
import com.example.demo.ServiceImpl.BusinessServiceImpl;
import com.example.demo.entities.Business;

@RunWith(SpringRunner.class)
@DataJpaTest

public class BusinessServiceImplTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	BusinessServiceImpl businessServiceImpl;

	@Test
	public void SaveBusiness() {

		Business business = createBusiness();

		Business SavedInDb = entityManager.persist(business);

		Business FromDb = businessServiceImpl.getBusinessById(SavedInDb.getId());

		assertThat(SavedInDb).isEqualTo(FromDb);

	}

	private Business createBusiness() {

		Business business = new Business("eslam", "123", "logooo", "123456789", "ahmedtttt@gmail.com", "tanta", "tanta",
				"tant", "tantaaa", 123, "url", "desc", "notes", "paypal", 0);

		return business;
	}
}
