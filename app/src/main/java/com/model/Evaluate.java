package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Evaluate {
    private int id;
    private int accountDetailID;
    private int productID;
    private String description;
    private int star;
    private boolean deleted;
}
