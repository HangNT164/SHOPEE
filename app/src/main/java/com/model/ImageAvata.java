package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class ImageAvata {
    private int id;
    private int accountDetailID;
    private String imageLink;
    private boolean deleted;
}
