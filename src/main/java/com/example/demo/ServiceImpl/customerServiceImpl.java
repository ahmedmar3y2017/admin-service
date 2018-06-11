package com.example.demo.ServiceImpl;

import com.example.demo.Service.customerService;
import com.example.demo.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class customerServiceImpl implements customerService {

    @Autowired
    customerServiceImpl customerService;


    @Override
    public Customers saveCustomers(Customers customer) {
        return customerService.saveCustomers(customer);
    }


    @Override
    public Customers getCustomersById(int id) {
        return customerService.getCustomersById(id);
    }

    @Override
    public List<Customers> getAll() {
        return customerService.getAll();
    }
}
