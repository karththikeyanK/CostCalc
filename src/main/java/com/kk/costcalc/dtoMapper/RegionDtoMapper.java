package com.kk.costcalc.dtoMapper;

import com.kk.costcalc.dto.RegionRequest;
import com.kk.costcalc.dto.RegionResponse;
import com.kk.costcalc.entity.Organization;
import com.kk.costcalc.entity.Region;
import com.kk.costcalc.service.OrganizationService;

public class RegionDtoMapper {



    public Region convertToEntity(RegionRequest regionRequest,OrganizationService organizationService) {
        Organization org = organizationService.getOrganizationEntity(regionRequest.getOrgId());
        Region region = new Region();
        region.setName(regionRequest.getName());
        region.setCode(regionRequest.getCode());
        region.setOrganization(org);
        return region;
    }

    public RegionResponse convertToResponse(Region region) {
        RegionResponse regionResponse = new RegionResponse();
        regionResponse.setId(region.getId());
        regionResponse.setName(region.getName());
        regionResponse.setCode(region.getCode());
        regionResponse.setOrgId(region.getOrganization().getId());
        return regionResponse;
    }

}
