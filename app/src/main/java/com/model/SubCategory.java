package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@Entity(tableName = "sub_category")
public class SubCategory {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ForeignKey(entity = Category.class, parentColumns = {"id"}, childColumns = {"category_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "category_id")
    private int categoryID;

    @ColumnInfo(name = "sub_cate_code")
    private String subCategoryCode;

    @ColumnInfo(name = "sub_cate_name")
    private String subCategoryName;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
