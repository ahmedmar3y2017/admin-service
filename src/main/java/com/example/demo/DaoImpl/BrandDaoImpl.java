package com.example.demo.DaoImpl;

import com.example.demo.Dao.BrandDao;
import com.example.demo.entities.Brands;
import org.hibernate.Criteria;
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
    public Brands updateBrands(int id, Brands brands) {


        Session session = sessionFactory.openSession();

        Brands brands1 = session.get(Brands.class, id);

        if (brands1 == null) {
            System.err.println("Not Found");
            return null;
        } else {

            brands1.setDescription(brands.getDescription());
            brands1.setName(brands.getName());
            brands1.setUrl(brands.getUrl());
            brands1.setLogo(brands.getLogo());
            session.beginTransaction();

            session.update(brands1);

            session.getTransaction().commit();

        }

        return brands1;


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
}
