package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Admin updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		return adminDaoImpl.updateAdmin(id, admin);
	}

	@Override
	public int deleteAdminById(int id) {
		// TODO Auto-generated method stub
		return adminDaoImpl.deleteAdminById(id);
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminDaoImpl.getAdminById(id);
	}

}
