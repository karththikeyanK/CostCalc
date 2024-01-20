package com.kk.costcalc.dtoMapper;

import com.kk.costcalc.dto.ShopRequest;
import com.kk.costcalc.dto.ShopResponse;
import com.kk.costcalc.entity.Shop;
import com.kk.costcalc.service.RegionService;


public class ShopDtoMapper {

    public Shop convertToEntity(ShopRequest shopRequest, RegionService regionService) {
        Shop shop = new Shop();
        shop.setName(shopRequest.getName());
        shop.setAddress(shopRequest.getAddress());
        shop.setContact(shopRequest.getContact());
        shop.setDistance(shopRequest.getDistance());
        shop.setRegNumber(shopRequest.getRegNumber());
        shop.setRegion(regionService.getRegionEntity(shopRequest.getRegionId()));
        return shop;
    }

    public ShopResponse convertToResponse(Shop shop) {
        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setId(shop.getId());
        shopResponse.setName(shop.getName());
        shopResponse.setAddress(shop.getAddress());
        shopResponse.setContact(shop.getContact());
        shopResponse.setDistance(shop.getDistance());
        shopResponse.setRegNumber(shop.getRegNumber());
        shopResponse.setRegionId(shop.getRegion().getId());
        return shopResponse;
    }

}
