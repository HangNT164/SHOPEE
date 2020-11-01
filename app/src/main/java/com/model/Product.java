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
@Entity(tableName = "product")
public class Product {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private  int id;

    @ForeignKey(entity = Size.class, parentColumns = {"id"}, childColumns = {"size_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "size_id")
    private int sizeID;

    @ForeignKey(entity = SubCategory.class, parentColumns = {"id"}, childColumns = {"sub_cate_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "sub_cate_id")
    private  int subCateID;

    @ColumnInfo(name = "product_code")
    private String productCode;

    @ColumnInfo(name = "product_name")
    private String productName;

    @ColumnInfo
    private int quantity;

    @ColumnInfo(name = "sell_price",defaultValue = "0")
    private  int sellPrice;

    @ColumnInfo(name = "origin_price",defaultValue = "0")
    private int originPrice;

    @ColumnInfo
    private  String color;

    @ColumnInfo
    private String description;

    @ColumnInfo(name = "create__date",defaultValue = "CURRENT_TIMESTAMP")
    private String createDate;

    @ColumnInfo(defaultValue = "0")
    private  boolean deleted;
}
