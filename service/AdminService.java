package com.anudip.training.service;

import java.util.List;

import com.anudip.training.entity.Admin;
import com.anudip.training.model.AdminDTO;

public interface AdminService {
	
	    //For adding new Admin details/records
		AdminDTO addAdmin(Admin admin);
		
		//For getting Admin details/records
		AdminDTO viewAdminDetails(int adminId);
		
		//For update Admin details/records
		AdminDTO updateAdminDetails(Admin admin, int adminId);
		
		//For deleting existing Admin deatils/records
		void deleteAdminDetails(int adminId);
		
		//Finding Admin By name
		List<AdminDTO> findAdminByName(String aname);
		
		//Getting All Admin List
		List<AdminDTO> getAllAdmins();

		//Finding Admin By Username
		List<AdminDTO> findAdminByUserName(String userName);
}
