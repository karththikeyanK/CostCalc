package com.kk.costcalc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionRequest {

    private String name;
    private String code;
    private Integer orgId;

}
