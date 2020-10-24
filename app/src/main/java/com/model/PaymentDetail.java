package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class PaymentDetail {
    private  int id;
    private String paymentDetailName;
    private  boolean deleted;
}
