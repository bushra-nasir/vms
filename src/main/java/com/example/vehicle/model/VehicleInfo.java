package com.example.vehicle.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class VehicleInfo {
	@Column(name = "Vehicle Manufacturer")
	public String manufacturer;
	@Column(name = "Vehicle Make Year")
	public int makeYear;
	@Column(name = "Vehicle Engine Type")
	public String engineType;
	@Column(name = "Vehicle Fuel Type")
	public String fuelType;
	@Column(name = "Hybrid")
	public boolean hybrid;
	@Column(name = "Electric")
	public boolean electric;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "Vehicle Chassis Number", nullable = false)
	public String chassisNumber;

	public VehicleInfo() {
		super();
	}

	public VehicleInfo(String manufacturer, int makeYear, String engineType, String fuelType, boolean hybrid,
			boolean electric, String chassisNumber) {
		super();
		this.manufacturer = manufacturer;
		this.makeYear = makeYear;
		this.engineType = engineType;
		this.fuelType = fuelType;
		this.hybrid = hybrid;
		this.electric = electric;
		this.chassisNumber = chassisNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(int makeYear) {
		this.makeYear = makeYear;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public boolean isHybrid() {
		return hybrid;
	}

	public void setHybrid(boolean hybrid) {
		this.hybrid = hybrid;
	}

	public boolean isElectric() {
		return electric;
	}

	public void setElectric(boolean electric) {
		this.electric = electric;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

}
