package com.kk.costcalc.repo;

import com.kk.costcalc.entity.Region;
import com.kk.costcalc.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    boolean existsByVehicleNumber(String vehicleNumber);

    List<Vehicle> findByRegion(Region region);
}
