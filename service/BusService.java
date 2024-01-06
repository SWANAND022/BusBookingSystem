package com.anudip.training.service;

import java.util.List;

import com.anudip.training.entity.Bus;
import com.anudip.training.model.BusDTO;

public interface BusService {
	
	//For adding new Bus details/records
	BusDTO addBus(Bus bus);
	
	//For getting Bus details/records
	BusDTO viewBusDetails(int busId);
	
	//For update Bus details/records
	BusDTO updateBusDetails(Bus bus, int busId);
	
	//For deleting existing Bus deatils/records
	void deleteBusDetails(int busId);

    // Finding Bus By No.
    List<BusDTO> findBusByNo(String busNo);

    // Getting All Bus List
    List<BusDTO> getAllBuses();

    // Get Bus By Type
    List<BusDTO> findBusByType(String type);

}
