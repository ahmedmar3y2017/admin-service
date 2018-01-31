package com.example.demo.Service;

import com.example.demo.entities.Business;

import java.util.List;

public interface BusinessService {
	public Business saveBusiness(Business business);

	public Business updateBusiness(int id, Business b);

	public int deleteBusinessById(int id);

	public Business getBusinessById(int id);

	public List<Business> getAll();

}
