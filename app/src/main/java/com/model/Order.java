package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Order {
    private int id;
    private int paymentDetailID;
    private int statusOrderID;
    private int customInfoID;
    private int accountDetailID;
    private int totalPrice;
    private String note;
    private String createDate;
    private boolean deleted;
}
