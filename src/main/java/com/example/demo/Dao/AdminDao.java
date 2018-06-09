package com.example.demo.Dao;

import com.example.demo.entities.Admin;

public interface AdminDao {
    public Admin saveAdmin(Admin admin);




    public Admin updateAdmin(int id, Admin admin);

    public int deleteAdminById(int id);

    public Admin getAdminById(int id);

    public Admin getAdminByUsername(String username);
//	public List<Admin>  getAllAdminByBusinessId(int businessId);

}
