package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Account {
    private int id;
    private int accountDetailID;
    private int roleID;
    private String email;
    private String password;
    private boolean deleted;
}
