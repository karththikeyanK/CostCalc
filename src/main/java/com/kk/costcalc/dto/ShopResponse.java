package com.kk.costcalc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopResponse {
    private Integer id;
    private String name;
    private String regNumber;
    private String address;
    private String contact;
    private Double distance;
    private Integer regionId;

}
