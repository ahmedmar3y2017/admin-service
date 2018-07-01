package com.example.demo.DaoImpl;

import com.example.demo.Dao.BrandDao;
import com.example.demo.entities.Brands;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */
@Transactional
@Component
public class BrandDaoImpl implements BrandDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Brands saveBrands(Brands brands) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(brands);

        session.getTransaction().commit();
        return brands;


    }

    @Override
    public Brands updateBrands(Brands brands) {


        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.update(brands);

        session.getTransaction().commit();


        return brands;


    }

    @Override
    public int deleteBrandsById(int id) {

        Session session = sessionFactory.openSession();

        Brands brands = session.get(Brands.class, id);

        if (brands == null) {
            return 0;

        } else {

            session.beginTransaction();

            session.delete(brands);

            session.getTransaction().commit();

            return 1;
        }


    }

    @Override
    public Brands getBrandsById(int id) {


        Session session = sessionFactory.openSession();

        Brands brands = session.get(Brands.class, id);
        return brands;


    }

    @Override
    public List<Brands> getAll() {


        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Brands.class);
        List<Brands> list = criteria.list();
        return list;


    }

    @Override
    public int deleteBrandsByAvailable(int id) {

        Session session = sessionFactory.openSession();

        Brands Brands = session.get(Brands.class, id);

        if (Brands == null) {
            return 0;

        } else {

            session.beginTransaction();
            // update flag
            Brands.setAvailable(false);
            session.update(Brands);

            session.getTransaction().commit();

            return 1;
        }

    }

    @Override
    public Brands getBrandsByProductId(int productid) {
//        Session session = sessionFactory.openSession();
//
//        session.beginTransaction();
//        Query query = session.createQuery("select so from Brands so where so.orderDate <= current_date and (so.orderDate + 0) >= (current_date - 7)");
//
//        List<Brands> orders = query.uniqueResult();
//
//
//        session.getTransaction().commit();

        return null;
    }
}
