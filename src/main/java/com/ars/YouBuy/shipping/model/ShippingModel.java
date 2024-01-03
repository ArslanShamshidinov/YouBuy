package com.ars.YouBuy.shipping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ShippingModel {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String state;
}
