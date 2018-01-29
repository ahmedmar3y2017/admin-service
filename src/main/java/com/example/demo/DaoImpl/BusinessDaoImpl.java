package com.example.demo.DaoImpl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.BusinessDao;

import com.example.demo.entities.Business;

import java.util.List;

@Transactional
@Component
public class BusinessDaoImpl implements BusinessDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Business saveBusiness(Business business) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(business);

		session.getTransaction().commit();
		return business;
	}

	@Override
	public Business updateBusiness(int id, Business b) {
		Session session = sessionFactory.openSession();

		Business business = session.get(Business.class, id);

		if (business == null) {
			System.err.println("Not Found");
			return null;
		} else {

			business.setUrl(b.getUrl());
			business.setState(b.getState());
			business.setPostalCode(b.getPostalCode());
			business.setPaymentMethods(b.getPaymentMethods());
			business.setNotes(b.getNotes());
			business.setName(b.getName());
			business.setLogo(b.getLogo());
			business.setEmail(b.getEmail());
			business.setDescription(b.getDescription());
			business.setCountry(b.getCountry());
			business.setContact(b.getContact());
			business.setCity(b.getCity());
			business.setAddress(b.getAddress());
			business.setActive(b.getActive());

			session.beginTransaction();

			session.update(business);

			session.getTransaction().commit();

		}

		return business;
	}

	@Override
	public int deleteBusinessById(int id) {
		Session session = sessionFactory.openSession();

		Business business = session.get(Business.class, id);

		if (business == null) {
			return 0;

		} else {

			session.beginTransaction();

			session.delete(business);

			session.getTransaction().commit();

			return 1;
		}

	}

	@Override
	public Business getBusinessById(int id) {
		Session session = sessionFactory.openSession();

		Business business = session.get(Business.class, id);
		return business;
	}

	@Override
	public List<Business> getAll() {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Business.class);
		List<Business> list =criteria.list();
		return list;
	}

}
