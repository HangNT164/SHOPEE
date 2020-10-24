package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class StatusOrderDetail {
    private int id;
    private String statusOrderName;
    private boolean deleted;
}
