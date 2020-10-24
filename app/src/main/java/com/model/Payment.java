package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Payment {
    private int id;
    private int paymentDetailID;
    private boolean deleted;
}
