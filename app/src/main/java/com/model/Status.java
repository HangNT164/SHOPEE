package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Status {
    private int id;
    private int productID;
    private int descriptionStatus;
    private String statusName;
    private boolean deleted;
}
