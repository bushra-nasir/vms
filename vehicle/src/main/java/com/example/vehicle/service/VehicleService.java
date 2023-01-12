package com.example.vehicle.service;

import java.io.Writer;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.vehicle.model.VehicleInfo;
import com.example.vehicle.search.SearchCriteria;

public interface VehicleService {
	VehicleInfo saveVehicle(VehicleInfo vehicle);
	List<VehicleInfo> getAllVehicles();
	VehicleInfo updateVehicle(VehicleInfo vehicle, String chassisNumber);
	List<VehicleInfo> getVehiclesByFilter(List<SearchCriteria> searchCriteria);
	 public void writeToCsv(Writer writer);
	List<VehicleInfo> writeFilteredToCsv(Writer writer, List<SearchCriteria> searchCriteria);
}
