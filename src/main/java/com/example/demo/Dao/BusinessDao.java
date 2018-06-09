package com.example.demo.Dao;

import com.example.demo.entities.Business;

import java.util.List;

public interface BusinessDao {

    public Business saveBusiness(Business business);

    public Business updateBusiness(Business b);

    public int deleteBusinessById(int id);

    public Business getBusinessById(int id);

    public List<Business> getAll();
}
