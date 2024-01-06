package com.anudip.training.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.entity.Bus;
import com.anudip.training.exception.RecordsNotFoundException;
import com.anudip.training.model.BusDTO;
import com.anudip.training.repository.BusRepository;
import com.anudip.training.service.BusService;
import com.anudip.training.util.BusConvertor;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	BusRepository brepo;
	
	@Autowired
	BusConvertor bconvertor;
	
	@Override
	public BusDTO addBus(Bus bus) {
	
	    brepo.save(bus);
	    return bconvertor.convertToBusDTO(bus);
	    
	}

	@Override
	public BusDTO viewBusDetails(int busId) {
		
		 Bus bus = brepo.findById(busId)
	                .orElseThrow(() -> new RecordsNotFoundException("Bush with Id '" + busId +"' Not Found!"));
	     return bconvertor.convertToBusDTO(bus);
	}

	@Override
	public BusDTO updateBusDetails(Bus bus, int busId) {
		
		 Bus updateBus = brepo.findById(busId)
	                .orElseThrow(() -> new RecordsNotFoundException("Bus with Id '" + busId + "' not found.."));

	        updateBus.setBusId(bus.getBusId());
	        updateBus.setBusNo(bus.getBusNo());
	        updateBus.setCapacity(bus.getCapacity());
	        updateBus.setType(bus.getType());

	        return bconvertor.convertToBusDTO(brepo.save(updateBus));
	}

	@Override
	public void deleteBusDetails(int busId) {
		
		brepo.findById(busId)
        .orElseThrow(() -> new RecordsNotFoundException("Bus with Id '" + busId + "' Not Found!"));
		brepo.deleteById(busId);
	}

	@Override
	public List<BusDTO> findBusByNo(String busNo) {
		
		List<Bus> buses = brepo.findByNoContaining(busNo);

        if (buses.isEmpty()) {
            throw new RecordsNotFoundException("Bus with number '" + busNo + "' not found!");
        }

        return bconvertor.convertToBusDTOList(buses);
	}

	@Override
	public List<BusDTO> getAllBuses() {
		
		List<Bus> buses = brepo.findAll();

        if (buses.isEmpty()) {
            throw new RecordsNotFoundException("Bus Records Not Found!");
        }

        return bconvertor.convertToBusDTOList(buses);
	}

	@Override
	public List<BusDTO> findBusByType(String type) {
	
		List<Bus> buses = brepo.findBytypeContaining(type);

        if (buses.isEmpty()) {
            throw new RecordsNotFoundException("Buses with type '" + type + "' are not found!");
        }

        return bconvertor.convertToBusDTOList(buses);
	}

}
