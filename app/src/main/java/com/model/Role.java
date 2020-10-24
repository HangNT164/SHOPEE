package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Role {
    private  int id;
    private String roleName;
    private  boolean deleted;
}
