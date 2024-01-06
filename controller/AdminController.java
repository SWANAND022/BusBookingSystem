package com.anudip.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.training.entity.Admin;
import com.anudip.training.model.AdminDTO;
import com.anudip.training.service.AdminService;
import com.anudip.training.util.AdminConvertor;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	AdminService as;
	
	@Autowired
	AdminConvertor aconvertor;
	
	@PostMapping("/saveAdmin")
	public AdminDTO saveAdmin(@RequestBody AdminDTO adto)
	{
		Admin admin1 = aconvertor.convertToAdminEntity(adto);
		
		return as.addAdmin(admin1);
	}
	
	@GetMapping("/getAdminDetails/{adminId}")
	public AdminDTO getAdminDetails(@PathVariable("adminId") int adminId)
	{
		return as.viewAdminDetails(adminId);
	}
	
	@PutMapping("/editAdminDetails/{adminId}")
	public AdminDTO editAdminDetails(@PathVariable("adminId")int adminId,@RequestBody AdminDTO adto)
	{
		Admin admin = aconvertor.convertToAdminEntity(adto);
        return as.updateAdminDetails(admin, adminId);
	}

	@DeleteMapping("/deleteAdminDetails/{adminId}")
	public ResponseEntity<String> deleteAdminDetails(@PathVariable("adminId") int adminId)
	{
		as.deleteAdminDetails(adminId);
		return new ResponseEntity<String>(" Admin with Id '" + adminId + "' is deleted Successfully..",HttpStatus.OK);
	}
	
	@GetMapping("/findAdminByName/{aname}")
    public List<AdminDTO> findAdminByName(@PathVariable("aname") String aname) {

		return as.findAdminByName(aname);
    }

    @GetMapping("/getAllAdmins")
    public List<AdminDTO> getAllAdmins() {
      
    	return as.getAllAdmins();
    }
    
    @GetMapping("/findAdminByUserName/{userName}")
    public List<AdminDTO> findAdminByUserName(@PathVariable("userName") String userName) {
      
    	return as.findAdminByUserName(userName);
    }

}
