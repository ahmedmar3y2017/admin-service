package com.example.demo.Service;

import com.example.demo.entities.Customers;

import java.util.List;

public interface customerService {

    public Customers saveCustomers(Customers category);

    public Customers getCustomersById(int id);

    public List<Customers> getAll();

}
