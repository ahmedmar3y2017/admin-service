package com.example.demo.Dao;

import com.example.demo.entities.Business;

public interface BusinessDao {

	public Business saveBusiness(Business business);

	public Business updateBusiness(int id, Business b);

	public int deleteBusinessById(int id);

	public Business getBusinessById(int id);

}
