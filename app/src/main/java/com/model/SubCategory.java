package com.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class SubCategory {
    private int id;
    private int categoryID;
    private String subCategoryCode;
    private String subCategoryName;
    private boolean deleted;
}
