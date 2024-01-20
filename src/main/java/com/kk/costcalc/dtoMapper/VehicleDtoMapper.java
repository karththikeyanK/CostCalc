package com.kk.costcalc.dtoMapper;

import com.kk.costcalc.dto.VehicleRequest;
import com.kk.costcalc.dto.VehicleResponse;
import com.kk.costcalc.entity.Vehicle;
import com.kk.costcalc.service.RegionService;

public class VehicleDtoMapper {

    public Vehicle ConvertToEntity(VehicleRequest vehicleRequest, RegionService regionService) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleRequest.getType());
        vehicle.setVehicleNumber(vehicleRequest.getVehicleNumber());
        vehicle.setCapacity(vehicleRequest.getCapacity());
        vehicle.setCostPerKM(vehicleRequest.getCostPerKM());
        vehicle.setRegion(regionService.getRegionEntity(vehicleRequest.getRegionId()));
        return vehicle;
    }

    public VehicleResponse ConvertToResponse(Vehicle vehicle) {
       VehicleResponse vehicleResponse = new VehicleResponse();
         vehicleResponse.setId(vehicle.getId());
         vehicleResponse.setType(vehicle.getType());
         vehicleResponse.setVehicleNumber(vehicle.getVehicleNumber());
         vehicleResponse.setCapacity(vehicle.getCapacity());
         vehicleResponse.setCostPerKM(vehicle.getCostPerKM());
         vehicleResponse.setRegionId(vehicle.getRegion().getId());
         return vehicleResponse;
    }
}
