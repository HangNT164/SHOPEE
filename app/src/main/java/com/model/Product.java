package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Product {
    private  int id;
    private int sizeID;
    private  int subCateID;
    private String productCode;
    private String productName;
    private int quantity;
    private  int sellPrice;
    private int originPrice;
    private  String color;
    private String description;
    private String createDate;
    private  boolean deleted;
}
