package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.DaoImpl.AdminDaoImpl;
import com.example.demo.Service.AdminService;
import com.example.demo.entities.Admin;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDaoImpl adminDaoImpl;

    @Override
    public Admin saveAdmin(Admin admin) {
        // TODO Auto-generated method stub
        return adminDaoImpl.saveAdmin(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        // TODO Auto-generated method stub
        return adminDaoImpl.updateAdmin(admin);
    }

//    @CacheEvict(value = "adminCache", key = "#id")
    @Override
    public int deleteAdminById(int id) {
        // TODO Auto-generated method stub
        return adminDaoImpl.deleteAdminById(id);
    }

//    @Cacheable(value = "adminCache", key = "#id", unless = "#result==null")
    @Override
    public Admin getAdminById(int id) {
        // TODO Auto-generated method stub
        return adminDaoImpl.getAdminById(id);
    }

//    @Cacheable(value = "adminCache", key = "#username", unless = "#result==null")
    @Override
    public Admin getAdminByUsername(String username) {
        return adminDaoImpl.getAdminByUsername(username);
    }

    @Override
    public int deleteAdminByAvailable(int adminid) {
        return adminDaoImpl.deleteAdminByAvailable(adminid);
    }


}
