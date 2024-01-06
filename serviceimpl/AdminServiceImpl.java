package com.anudip.training.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.entity.Admin;
import com.anudip.training.exception.RecordsNotFoundException;
import com.anudip.training.model.AdminDTO;
import com.anudip.training.repository.AdminRepository;
import com.anudip.training.service.AdminService;
import com.anudip.training.util.AdminConvertor;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository  arepo;
	
	@Autowired
	AdminConvertor aconvertor;
	
	@Override
	public AdminDTO addAdmin(Admin admin) {
		
		arepo.save(admin);
	    return aconvertor.convertToAdminDTO(admin);
	}

	@Override
	public AdminDTO viewAdminDetails(int adminId) {
		
		Admin admin = arepo.findById(adminId)
                .orElseThrow(() -> new RecordsNotFoundException("Admin  with Id '" + adminId + "' Not Found!"));
        return aconvertor.convertToAdminDTO(admin);
	}

	@Override
	public AdminDTO updateAdminDetails(Admin admin, int adminId) {
		
		Admin updateAdmin = arepo.findById(adminId)
                .orElseThrow(() -> new RecordsNotFoundException("Admin with id '" + adminId + "' not found.."));

        updateAdmin.setAdminId(admin.getAdminId());
        updateAdmin.setAname(admin.getAname());
        updateAdmin.setContact(admin.getContact());
        updateAdmin.setUserName(admin.getUserName());
        updateAdmin.setPassword(admin.getPassword());

        return aconvertor.convertToAdminDTO(arepo.save(updateAdmin));
	}

	@Override
	public void deleteAdminDetails(int adminId) {
		
		arepo.findById(adminId)
        .orElseThrow(() -> new RecordsNotFoundException("Admin with Id '" + adminId + "' Not Found!"));
		arepo.deleteById(adminId);

	}

	@Override
	public List<AdminDTO> findAdminByName(String aname) {
		
		List<Admin> admin = arepo.findByNameContaining(aname);

        if (admin.isEmpty()) {
        	
            throw new RecordsNotFoundException("Admin with name '" + aname + "' not found!");
        }

        return aconvertor.convertToAdminDTOList(admin);
		
	}
	
	@Override
	public List<AdminDTO> getAllAdmins() {
		
		List<Admin> admin = arepo.findAll();

        if (admin.isEmpty()) {
            throw new RecordsNotFoundException("Admin Records Not Found!");
        }

        return aconvertor.convertToAdminDTOList(admin);
	}

	@Override
	public List<AdminDTO> findAdminByUserName(String userName) {
		
		List<Admin> admin = arepo.findByUserNameContaining(userName);

        if (admin.isEmpty()) {
            throw new RecordsNotFoundException("Admin with username '" + userName + "' not found!");
        }

        return aconvertor.convertToAdminDTOList(admin);
	}

}
