//package com.example.vehicle.controller;
//
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.example.vehicle.model.VehicleInfo;
//import com.example.vehicle.service.VehicleService;
//
//public class VehicleCtrl {
//	
//	private VehicleService vehicleService;
//
//	public VehicleCtrl(VehicleService vehicleService) {
//		super();
//		this.vehicleService = vehicleService;
//	}
//
//	@RequestMapping(value="/add")
//	public String addVehicle(Map<String, Object> model) {
//	VehicleInfo	vehicle = new VehicleInfo();
//	model.put("vehicle", vehicle);
//	return "add";
//
//	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String saveCustomer(@ModelAttribute("vehicle") VehicleInfo vehicle) {
//	    vehicleService.saveVehicle(vehicle);
//	    return "redirect:/";
//	}
//
//	
//	@RequestMapping("/updateVehicle")
//	public ModelAndView editCustomerForm(@RequestParam String chassisNumber) {
//	    ModelAndView mav = new ModelAndView("update");
//	    VehicleInfo vehicle = vehicleService.get(chassisNumber);
//	    mav.addObject("vehicle", vehicle);
//	 
//	    return mav;
//	}
//
//
//}
