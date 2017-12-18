package com.example.demo.Dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DaoImpl.AdminDaoImpl;
import com.example.demo.DaoImpl.BusinessDaoImpl;
import com.example.demo.entities.Business;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BusinessDaoTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	BusinessDaoImpl businessDaoImpl;

	@Test
	public void SaveBusiness() {

		Business business = createBusiness();

		Business SavedInDb = entityManager.persist(business);

		Business FromDb = businessDaoImpl.getBusinessById(SavedInDb.getId());

		assertThat(SavedInDb).isEqualTo(FromDb);

	}

	private Business createBusiness() {

		Business business = new Business("eslam", "123", "logooo", "123456789", "ahmedtttt@gmail.com", "tanta", "tanta",
				"tant", "tantaaa", 123, "url", "desc", "notes", "paypal", 0);

		return business;
	}
}
