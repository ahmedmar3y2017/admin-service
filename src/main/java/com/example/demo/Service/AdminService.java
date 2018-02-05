package com.example.demo.Service;

import com.example.demo.entities.Admin;

public interface AdminService {
	public Admin saveAdmin(Admin admin);

	public Admin updateAdmin(int id, Admin admin);

	public int deleteAdminById(int id);

	public Admin getAdminById(int id);
	public Admin getAdminByUsername(String username);

//	public Admin saveAdmin(int businessid, Admin admin);

}
