package com.example.demo.DaoImpl;

import com.example.demo.Dao.CategoryDao;
import com.example.demo.entities.Category;
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
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category saveCategory(Category category) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(category);

        session.getTransaction().commit();
        return category;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Session session = sessionFactory.openSession();

        Category category1 = session.get(Category.class, id);

        if (category1 == null) {
            System.err.println("Not Found");
            return null;
        } else {

            category1.setActive(category.getActive());
            category1.setName(category.getName());
            category1.setParentId(category.getParentId());
            category1.setPic(category.getPic());
            session.beginTransaction();

            session.update(category1);

            session.getTransaction().commit();

        }

        return category1;
    }

    @Override
    public int deleteCategoryById(int id) {
        Session session = sessionFactory.openSession();

        Category category = session.get(Category.class, id);

        if (category == null) {
            return 0;

        } else {

            session.beginTransaction();

            session.delete(category);

            session.getTransaction().commit();

            return 1;
        }

    }

    @Override
    public Category getCategoryById(int id) {
        Session session = sessionFactory.openSession();

        Category category = session.get(Category.class, id);
        return category;
    }

    @Override
    public List<Category> getAll() {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Category.class);
        List<Category> list =criteria.list();
        return list;
    }
}
