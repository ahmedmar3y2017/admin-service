package com.example.demo.DaoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.AdminDao;
import com.example.demo.entities.Admin;

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
    public Admin updateAdmin(Admin admin) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(admin);

        session.getTransaction().commit();

        return admin;
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
        session.close();

        return admin;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Admin.class);
        criteria.add(Restrictions.eq("username", username));
        Admin admin = (Admin) criteria.uniqueResult();

        return admin;


    }

    @Override
    public int deleteAdminByAvailable(int adminid) {
        Session session = sessionFactory.openSession();

        Admin business = session.get(Admin.class, adminid);

        if (business == null) {
            return 0;

        } else {

            session.beginTransaction();
            // update flag
            business.setAvailable(false);
            session.update(business);

            session.getTransaction().commit();

            return 1;
        }


    }


}
