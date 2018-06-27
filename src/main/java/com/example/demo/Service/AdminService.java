package com.example.demo.Service;

import com.example.demo.entities.Admin;

public interface AdminService {
    public Admin saveAdmin(Admin admin);

    public Admin updateAdmin(Admin admin);

    public int deleteAdminById(int id);

    public Admin getAdminById(int id);

    public Admin getAdminByUsername(String username);

    public int deleteAdminByAvailable(int adminid);
    public Admin loginAdmin(String email, String password);

//	public Admin saveAdmin(int businessid, Admin admin);

}
