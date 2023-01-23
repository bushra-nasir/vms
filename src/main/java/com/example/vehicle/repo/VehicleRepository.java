package com.example.vehicle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.vehicle.model.VehicleInfo;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleInfo, String>, JpaSpecificationExecutor<VehicleInfo> {

}
