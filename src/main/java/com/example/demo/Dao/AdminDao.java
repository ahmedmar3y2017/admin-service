package com.example.demo.Dao;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Business;

import java.util.List;

public interface AdminDao {
	public Admin saveAdmin(Admin admin);

	public Admin updateAdmin(int id, Admin admin);

	public int deleteAdminById(int id);

	public Admin getAdminById(int id);

//	public List<Admin>  getAllAdminByBusinessId(int businessId);

}
