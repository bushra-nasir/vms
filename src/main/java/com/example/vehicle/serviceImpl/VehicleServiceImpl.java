package com.example.vehicle.serviceImpl;

import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import com.example.vehicle.exception.CustomException;
import com.example.vehicle.model.VehicleInfo;
import com.example.vehicle.repo.VehicleRepository;
import com.example.vehicle.search.SearchCriteria;
import com.example.vehicle.search.VehicleSpecification;
import com.example.vehicle.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	private VehicleRepository vehicleRepo;

	public VehicleServiceImpl(VehicleRepository vehicleRepo) {
		super();
		this.vehicleRepo = vehicleRepo;
	}

	@Override
	public VehicleInfo saveVehicle(VehicleInfo vehicle) {
		return vehicleRepo.save(vehicle);
	}

	@Override
	public List<VehicleInfo> getAllVehicles() {
		return vehicleRepo.findAll();
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VehicleInfo get(String chassisNumber) {
		return vehicleRepo.getById(chassisNumber);
	}

	@Override
	public VehicleInfo updateVehicle(VehicleInfo vehicle, String chassisNumber) {
		//Integer chassisInt = Integer.parseInt(chassisNumber);
		VehicleInfo existingVehicle = vehicleRepo.findById(chassisNumber)
				.orElseThrow(() -> new CustomException("Vehicle with this chassis number does not exist."));
		existingVehicle.setManufacturer(vehicle.getManufacturer());
		existingVehicle.setMakeYear(vehicle.getMakeYear());
		existingVehicle.setHybrid(vehicle.isHybrid());
		existingVehicle.setFuelType(vehicle.getFuelType());
		existingVehicle.setEngineType(vehicle.getEngineType());
		existingVehicle.setElectric(vehicle.isElectric());
		existingVehicle.setChassisNumber(chassisNumber.toString());
		vehicleRepo.save(existingVehicle);
		return existingVehicle;

	}

	@Override
	public List<VehicleInfo> getVehiclesByFilter(List<SearchCriteria> searchCriteria) {
		VehicleSpecification specification = new VehicleSpecification();
		searchCriteria.stream().map(searchCriterion -> new SearchCriteria(searchCriterion.getKey(),
				searchCriterion.getOperation(), searchCriterion.getValue())).forEach(specification::add);
		List<VehicleInfo> filteredList = vehicleRepo.findAll(specification);
		return filteredList;
	}

	@Override
	public void writeToCsv(Writer writer) {
		List<VehicleInfo> veh = vehicleRepo.findAll();
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for (VehicleInfo v : veh) {
				csvPrinter.printRecord(v.getChassisNumber(), v.getEngineType(), v.getFuelType(), v.getMakeYear(),
						v.getManufacturer(), v.isElectric(), v.isHybrid());
			}

		} catch (Exception e) {
			System.out.println("Error while writing to File!");
		}
	}

	@Override
	public List<VehicleInfo> writeFilteredToCsv(Writer writer, List<SearchCriteria> searchCriteria) {
		VehicleSpecification specification = new VehicleSpecification();
		searchCriteria.stream().map(searchCriterion -> new SearchCriteria(searchCriterion.getKey(),
				searchCriterion.getOperation(), searchCriterion.getValue())).forEach(specification::add);
		List<VehicleInfo> filteredList = vehicleRepo.findAll(specification);
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for (VehicleInfo v : filteredList) {
				csvPrinter.printRecord(v.getChassisNumber(), v.getEngineType(), v.getFuelType(), v.getMakeYear(),
						v.getManufacturer(), v.isElectric(), v.isHybrid());
			}

		} catch (Exception e) {
			System.out.println("Error while writing to File!");
		}
		return filteredList;
	}
}
