package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Size {
    private  int id;
    private String sizeName;
    private boolean deleted;
}
