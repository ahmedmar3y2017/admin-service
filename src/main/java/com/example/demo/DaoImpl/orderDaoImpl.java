package com.example.demo.DaoImpl;

import com.example.demo.Dao.orderDao;
import com.example.demo.entities.Orders;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Component
public class orderDaoImpl implements orderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Orders saveOrders(Orders orders) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(orders);

        session.getTransaction().commit();
        return orders;
    }

    @Override
    public int deleteOrdersByAvailable(int id) {
        Session session = sessionFactory.openSession();

        Orders order = session.get(Orders.class, id);

        if (order == null) {
            return 0;

        } else {

            session.beginTransaction();
            // update flag
            order.setAvailable(false);
            session.update(order);

            session.getTransaction().commit();

            return 1;
        }
    }

    @Override
    public Orders getOrdersById(int id) {
        Session session = sessionFactory.openSession();

        Orders category = session.get(Orders.class, id);
        return category;
    }

    @Override
    public List<Orders> getAll() {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Orders.class);
        List<Orders> list = criteria.list();
        return list;
    }

    @Override
    public List<Orders> getAllInWeek() {

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("select so from Orders so where so.orderDate <= current_date and (so.orderDate + 0) >= (current_date - 7)");

        List<Orders> orders = query.list();


        session.getTransaction().commit();


        return orders;
    }

    @Override
    public List<Orders> getAllInMonth() {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("select so from Orders so where MONTH(so.orderDate) = MONTH(:date)");
        query.setParameter("date", new Date());

        List<Orders> orders = query.list();


        session.getTransaction().commit();


        return orders;
    }
}
