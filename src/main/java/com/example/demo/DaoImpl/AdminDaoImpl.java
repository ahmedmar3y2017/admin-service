package com.example.demo.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.AdminDao;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Business;

@Transactional
@Component
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Admin saveAdmin(Admin admin) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(admin);

		session.getTransaction().commit();
		return admin;
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		Session session = sessionFactory.openSession();

		Admin aadmin = session.get(Admin.class, id);

		if (aadmin == null) {
			System.err.println("Not Found");
			return null;
		} else {

			session.beginTransaction();

			aadmin.setActive(admin.getActive());
			aadmin.setAddress1(admin.getAddress1());
			aadmin.setAddress2(admin.getAddress2());
			aadmin.setAdminLevel(admin.getAdminLevel());
			aadmin.setCity(admin.getCity());
			aadmin.setCountry(admin.getCountry());
			aadmin.setEmail(admin.getEmail());
			aadmin.setFirstName(admin.getFirstName());
			aadmin.setLastActive(admin.getLastActive());
			aadmin.setPassword(admin.getPassword());
			aadmin.setPhone(admin.getPhone());
			aadmin.setPostalCode(admin.getPostalCode());
			aadmin.setRegisterDate(admin.getRegisterDate());
			aadmin.setState(admin.getState());
			aadmin.setBusiness(admin.getBusiness());

			session.update(aadmin);

			session.getTransaction().commit();

		}

		return aadmin;
	}

	@Override
	public int deleteAdminById(int id) {
		Session session = sessionFactory.openSession();

		Admin admin = session.get(Admin.class, id);

		if (admin == null) {
			return 0;

		} else {

			session.beginTransaction();

			session.delete(admin);

			session.getTransaction().commit();

			return 1;
		}
	}

	@Override
	public Admin getAdminById(int id) {

		Session session = sessionFactory.openSession();

		Admin admin = session.get(Admin.class, id);

		return admin;
	}

}
