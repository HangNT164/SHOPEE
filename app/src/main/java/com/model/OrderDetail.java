package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class OrderDetail {
    private  int id;
    private int statusOrderID;
    private  int orderID;
    private int productID;
    private String productName;
    private int originPrice;
    private int sellPrice;
    private int quantity;
    private  String createDate;
    private  String shipDate;
    private  boolean deleted;
}
