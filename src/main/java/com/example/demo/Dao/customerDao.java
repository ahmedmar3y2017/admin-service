package com.example.demo.Dao;

import com.example.demo.entities.Customers;

import java.util.List;

public interface customerDao {

    public Customers saveCustomers(Customers category);

    public Customers getCustomersById(int id);

    public List<Customers> getAll();


}
