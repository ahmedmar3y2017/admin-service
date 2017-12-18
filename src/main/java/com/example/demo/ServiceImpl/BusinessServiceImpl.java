package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.BusinessDaoImpl;
import com.example.demo.Service.BusinessService;
import com.example.demo.entities.Business;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	BusinessDaoImpl business;

	@Override
	public Business saveBusiness(Business busines) {
		// TODO Auto-generated method stub
		return business.saveBusiness(busines);
	}

	@Override
	public Business updateBusiness(int id, Business b) {
		// TODO Auto-generated method stub
		return business.updateBusiness(id, b);
	}

	@Override
	public int deleteBusinessById(int id) {
		// TODO Auto-generated method stub
		return business.deleteBusinessById(id);
	}

	@Override
	public Business getBusinessById(int id) {
		// TODO Auto-generated method stub
		return business.getBusinessById(id);
	}

}
