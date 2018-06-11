package com.example.demo.DaoImpl;

import com.example.demo.Dao.customerDao;
import com.example.demo.entities.Customers;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class customerDaoImpl implements customerDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Customers saveCustomers(Customers customer) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(customer);

        session.getTransaction().commit();
        return customer;
    }


    @Override
    public Customers getCustomersById(int id) {
        Session session = sessionFactory.openSession();

        Customers customer = session.get(Customers.class, id);
        return customer;
    }

    @Override
    public List<Customers> getAll() {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Customers.class);
        List<Customers> list = criteria.list();
        return list;
    }
}
