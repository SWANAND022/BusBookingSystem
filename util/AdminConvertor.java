package com.anudip.training.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.entity.Admin;
import com.anudip.training.model.AdminDTO;

@Component
public class AdminConvertor {
	
	//converting Admin Entity to Admin DTO
	
			public AdminDTO convertToAdminDTO(Admin admin){
				
				AdminDTO adto = new AdminDTO();
				if(admin != null)
				{
					//copy data from Admin to AdminDTO
					BeanUtils.copyProperties(admin, adto);
					
				}
				return adto;
			}
			
			//converting Admin dto to Admin entity
			public Admin convertToAdminEntity(AdminDTO adto){
					
					Admin admin = new Admin();
					if(adto != null)
					{
						//copy data from Admin to AdminDTO
						BeanUtils.copyProperties(adto, admin);
						
					}
					return admin;
				}
			
			 // converting List of Admin Entities to List of AdminDTOs
		    public List<AdminDTO> convertToAdminDTOList(List<Admin> admins) {
		        return admins.stream()
		                .map(this::convertToAdminDTO)
		                .collect(Collectors.toList());
		    }
	

}
