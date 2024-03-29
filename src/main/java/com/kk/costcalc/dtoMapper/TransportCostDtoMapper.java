package com.kk.costcalc.dtoMapper;

import com.kk.costcalc.dto.CostRequest;
import com.kk.costcalc.dto.CostResponse;
import com.kk.costcalc.entity.Shop;
import com.kk.costcalc.entity.TransportCost;
import com.kk.costcalc.entity.TransportCostManger;
import com.kk.costcalc.exception.GeneralBusinessException;
import com.kk.costcalc.service.ShopService;
import com.kk.costcalc.service.VehicleService;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TransportCostDtoMapper {

    public TransportCost ConvertToEntity(CostRequest costRequest, ShopService shopService, VehicleService vehicleService) {
        log.info("Transport Dto Mapper::Converting to entity: {}", costRequest);
        try{
            TransportCost transportCost = new TransportCost();
            transportCost.setStatus(costRequest.getStatus());
            transportCost.setDate(costRequest.getDate());
            transportCost.setVehicle(vehicleService.getVehicleEntity(costRequest.getVehicleId()));
            List<Shop> shops = costRequest.getShopId().stream().map(shopService::getShopEntity).collect(Collectors.toList());
            log.info("Transport Dto Mapper::Shop: {}", shops.toString());
            transportCost.setCost(calculateCost(shops,transportCost.getVehicle().getCostPerKM()));
           if (shops.isEmpty()){
               log.error("TransportDto Mapper::Shop not found with id: {}", costRequest.getShopId());
               throw new GeneralBusinessException("Shop not found with id: " + costRequest.getShopId());
           }
           log.info("Transport Dto Mapper::Many To Many ");


            transportCost.setShops(new HashSet<>(shops));
            return transportCost;
        }catch (GeneralBusinessException ex){
            throw ex;
        }
        catch (Exception e){
          log.error("Error while converting to entity: {}", e.getMessage());
            throw e;
        }

    }

    public CostResponse ConvertToResponse(TransportCost transportCost) {
        log.info("Transport Dto Mapper::Converting to Response");
        try{
            CostResponse costResponse = new CostResponse();
            costResponse.setId(transportCost.getId());
            costResponse.setCost(transportCost.getCost());
            costResponse.setStatus(transportCost.getStatus());
            costResponse.setDate(transportCost.getDate());
            costResponse.setVehicleId(transportCost.getVehicle().getId());
            costResponse.setShopId(transportCost.getShops().stream().map(Shop::getId).collect(Collectors.toList()));
            return costResponse;
        }catch (Exception e){
            log.error("Error while converting to dto: {}", e.getMessage());
            throw e;
        }

    }

    private Double calculateCost(List<Shop> shops, Double costPerKm){
        log.info("Transport Dto Mapper::Calculating cost");
        try{
            Double cost = 0.0;
            for (Shop shop: shops) {
                cost += shop.getDistance() * costPerKm;
            }
            log.info("Transport Dto Mapper::Cost: {}", cost);
            return cost;
        }catch (Exception e){
            log.error("Transport Dto Mapper::Error while calculating cost: {}", e.getMessage());
            throw e;
        }
    }

    public CostResponse ConvertToManagerResponse(TransportCostManger transportCostManger) {
        log.info("Transport Dto Mapper::Converting to Manager Response");
        try{
            CostResponse costResponse = new CostResponse();
            costResponse.setId(transportCostManger.getTransportCost().getId());
            costResponse.setCost(transportCostManger.getTransportCost().getCost());
            costResponse.setStatus(transportCostManger.getTransportCost().getStatus());
            costResponse.setDate(transportCostManger.getTransportCost().getDate());
            costResponse.setVehicleId(transportCostManger.getTransportCost().getVehicle().getId());
            costResponse.setShopId(Collections.singletonList(transportCostManger.getShop().getId()));
            return costResponse;
        }catch (Exception e){
            log.error("Error while converting to dto: {}", e.getMessage());
            throw e;
        }
    }
}
