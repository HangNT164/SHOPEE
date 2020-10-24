package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class AccountDetail {
    private int id;
    private String name;
    private String mobile;
    private boolean gender;
    private String address;
    private String createDate;
    private boolean deleted;
}
