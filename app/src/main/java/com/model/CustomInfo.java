package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CustomInfo {
    private int id;
    private String customerName;
    private String mobile;
    private String address;
    private boolean deleted;
}
