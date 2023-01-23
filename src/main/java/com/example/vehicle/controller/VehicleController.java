package com.example.vehicle.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import com.example.vehicle.model.VehicleInfo;
import com.example.vehicle.search.SearchCriteria;
import com.example.vehicle.service.UserService;
import com.example.vehicle.service.VehicleService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	private VehicleService vehicleService;
	UserService userService;

	public VehicleController(VehicleService vehicleService, UserService userService) {
		super();
		this.vehicleService = vehicleService;
		this.userService = userService;
		}
	

//	public VehicleController(UserService userService) {
//		super();
//		this.userService = userService;
//	}
//	
//	public VehicleController() {
//		super();
//	}
	
	
@PostMapping("/add")
	public ResponseEntity<VehicleInfo> addVehicle(@RequestBody VehicleInfo vehicle) {
		return new ResponseEntity<VehicleInfo>(vehicleService.saveVehicle(vehicle), HttpStatus.CREATED);

	}
	
	
	@GetMapping("/getAll")
	public List<VehicleInfo> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	@PatchMapping("updateVehicle/{ch}/{un}/{pwd}")
	public ResponseEntity<VehicleInfo> updateDetails(@PathVariable("ch") String chassisNumber,@PathVariable("un") String username,@PathVariable("pwd") String password,
			@RequestBody VehicleInfo vehicle) {
		String validation = userService .validateUser(username, password);
		if(validation.equals("User not authorized")) {
			return null;
//			
//		String uri = "/api/validateUser/{username}/{password}";
//		RestTemplate template = new RestTemplate();
//		String access = template.getForObject(uri, String.class);
//		if(access.equals("Username not found! Access denied.")) {
//			return null;
		} else
		return new ResponseEntity<VehicleInfo>(vehicleService.updateVehicle(vehicle, chassisNumber), HttpStatus.OK);
	}


	
	@PostMapping("/getByFilter/{spec}")
	public ResponseEntity<List<VehicleInfo>> getFilteredVehicles(@RequestBody List<SearchCriteria> searchCriteria) {
		return new ResponseEntity<List<VehicleInfo>>(vehicleService.getVehiclesByFilter(searchCriteria), HttpStatus.OK);
	}

	@RequestMapping(path = "/csvFile")
	public void getVehiclesInCsv(HttpServletResponse servletResponse) throws Exception {
		servletResponse.setContentType("text/csv");
		servletResponse.addHeader("Content-Disposition", "attachment; filename=\"vehicles.csv\"");
		vehicleService.writeToCsv(servletResponse.getWriter());
	}

	@PostMapping(path = "getByFilter/csvFile")
	public void getFilteredVehiclesInCsv(HttpServletResponse servletResponse,
			@RequestBody List<SearchCriteria> searchCriteria) throws Exception {
		servletResponse.setContentType("text/csv");
		servletResponse.addHeader("Content-Disposition", "attachment; filename=\"vehicles.csv\"");
		vehicleService.writeFilteredToCsv(servletResponse.getWriter(), searchCriteria);
	}
}
