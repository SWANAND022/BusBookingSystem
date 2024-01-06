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

import com.anudip.training.entity.Bus;
import com.anudip.training.model.BusDTO;
import com.anudip.training.service.BusService;
import com.anudip.training.util.BusConvertor;

@RestController
@RequestMapping("/Bus")
public class BusController {
	
	@Autowired 
	BusService bs;
	
	@Autowired
	BusConvertor bconvertor;
	
	@PostMapping("/saveBus")
	public BusDTO saveBus(@RequestBody BusDTO bdto)
	{
		Bus bus1 = bconvertor.convertToBusEntity(bdto);
		
		return bs.addBus(bus1);
	}
	
	@GetMapping("/getBusDetails/{busId}")
	public BusDTO getBusDetails(@PathVariable("busId") int busId)
	{
		return bs.viewBusDetails(busId);
	}
	
	@PutMapping("/editBusDetails/{busId}")
	public BusDTO editBusDetails(@PathVariable("busId")int busId,@RequestBody BusDTO bdto)
	{
		Bus bus1 = bconvertor.convertToBusEntity(bdto);
        return bs.updateBusDetails(bus1, busId);
	}

	@DeleteMapping("/deleteBusDetails/{busId}")
	public ResponseEntity<String> deleteBusDetails(@PathVariable("busId") int busId)
	{
	
		bs.deleteBusDetails(busId);
		return new ResponseEntity<String>("deleted Successfully..",HttpStatus.OK);
	}
	
	@GetMapping("/findBusByNo/{busNo}")
    public List<BusDTO> findBusByNo(@PathVariable("busNo") String busNo) {
        
		return bs.findBusByNo(busNo);
    }
	
	@GetMapping("/getAllBuses")
    public List<BusDTO>  getAllBuses() {
		
        return bs.getAllBuses();
    }
	
	@GetMapping("/findBusByType/{type}")
    public List<BusDTO> findBusByType(@PathVariable("type") String type) {
        return bs.findBusByType(type);
    }

}
