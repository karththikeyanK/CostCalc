package com.CBL.CostCalculator.dto;

import com.CBL.CostCalculator.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponse {
    private Integer id;
    private String name;
    private String regNo;

}
