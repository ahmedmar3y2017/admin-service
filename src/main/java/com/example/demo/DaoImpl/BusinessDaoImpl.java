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
    public Business updateBusiness(Business b) {
        Session session = sessionFactory.openSession();


        session.beginTransaction();

        session.update(b);

        session.getTransaction().commit();


        return b;
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
        List<Business> list = criteria.list();
        return list;
    }

    @Override
    public int deleteBusinessByAvailable(int id) {

        Session session = sessionFactory.openSession();

        Business business = session.get(Business.class, id);

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
