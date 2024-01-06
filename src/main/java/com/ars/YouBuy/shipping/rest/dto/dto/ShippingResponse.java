package com.ars.YouBuy.shipping.rest.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ShippingResponse {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String state;
}
