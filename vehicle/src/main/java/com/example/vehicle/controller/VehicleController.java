package com.example.vehicle.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicle.model.VehicleInfo;
import com.example.vehicle.search.SearchCriteria;
import com.example.vehicle.service.VehicleService;

import jakarta.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	private VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {
		super();
		this.vehicleService = vehicleService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<VehicleInfo> addVehicle(@RequestBody VehicleInfo vehicle) {
		return new ResponseEntity<VehicleInfo>(vehicleService.saveVehicle(vehicle), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAll")
	public List<VehicleInfo> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}
	
	@PutMapping("getVehicle/{ch}")
	public ResponseEntity<VehicleInfo> updateDetails(@PathVariable("ch") String chassisNumber, @RequestBody VehicleInfo vehicle) {
		return new ResponseEntity<VehicleInfo>(vehicleService.updateVehicle(vehicle, chassisNumber), HttpStatus.OK);
	}
	
	@PostMapping("/getByFilter")
	public ResponseEntity <List<VehicleInfo>> getFilteredVehicles(@RequestBody List<SearchCriteria> searchCriteria ) {
		return new  ResponseEntity<List<VehicleInfo>> (vehicleService.getVehiclesByFilter(searchCriteria), HttpStatus.OK) ;
	}

	@RequestMapping(path = "/csvFile")
    public void getVehiclesInCsv(HttpServletResponse servletResponse) throws Exception {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"vehicles.csv\"");
        vehicleService.writeToCsv(servletResponse.getWriter());
    }
	
	@PostMapping(path = "getByFilter/csvFile")
    public void getFilteredVehiclesInCsv(HttpServletResponse servletResponse, @RequestBody List<SearchCriteria> searchCriteria) throws Exception {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"vehicles.csv\"");
        vehicleService.writeFilteredToCsv(servletResponse.getWriter(), searchCriteria);
    }
	}
