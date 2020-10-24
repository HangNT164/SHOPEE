package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Category {
    private int id;
    private String ccategoryCode;
    private String categoryName;
    private boolean deleted;
}
