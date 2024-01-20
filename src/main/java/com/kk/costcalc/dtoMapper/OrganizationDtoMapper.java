package com.kk.costcalc.dtoMapper;

import com.kk.costcalc.dto.OrganizationRequest;
import com.kk.costcalc.dto.OrganizationResponse;
import com.kk.costcalc.entity.Organization;

public class OrganizationDtoMapper {

    public Organization convertToEntity(OrganizationRequest organizationRequest) {
        Organization organization = new Organization();
        organization.setName(organizationRequest.getName());
        organization.setRegNo(organizationRequest.getRegNo());
        return organization;
    }

    public OrganizationResponse convertToResponse(Organization organization) {
        OrganizationResponse organizationResponse = new OrganizationResponse();
        organizationResponse.setId(organization.getId());
        organizationResponse.setName(organization.getName()); // Adjust based on response mapping requirement
        organizationResponse.setRegNo(organization.getRegNo()); // Adjust based on response mapping requirement
        return organizationResponse;
    }
}

