package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.BusinessDaoImpl;
import com.example.demo.Service.BusinessService;
import com.example.demo.entities.Business;

import java.util.List;

@Service

public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessDaoImpl business;

    @Override
    public Business saveBusiness(Business busines) {
        // TODO Auto-generated method stub
        return business.saveBusiness(busines);
    }

    @CachePut(value = "businessCache", key = "#id")
    @Override
    public Business updateBusiness(int id, Business b) {
        // TODO Auto-generated method stub
        return business.updateBusiness(id, b);
    }

    @CacheEvict(value = "businessCache", key = "#id")
    @Override
    public int deleteBusinessById(int id) {
        // TODO Auto-generated method stub
        return business.deleteBusinessById(id);
    }

    @Cacheable(value = "businessCache", key = "#id" , unless="#result==null")
    @Override
    public Business getBusinessById(int id) {
        // TODO Auto-generated method stub
        return business.getBusinessById(id);
    }

    @Cacheable(value = "businessCache" , unless="#result==null")
    @Override
    public List<Business> getAll() {
        return business.getAll();
    }

}
