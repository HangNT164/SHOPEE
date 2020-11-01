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
@Entity(tableName = "order_detail")
public class OrderDetail {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ForeignKey(entity = Order.class, parentColumns = {"id"}, childColumns = {"order_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "order_id")
    private int orderID;

    @ForeignKey(entity = Product.class, parentColumns = {"id"}, childColumns = {"product_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "product_id")
    private int productID;

    @ColumnInfo(name = "product_name")
    private String productName;

    @ColumnInfo(name = "origin_price", defaultValue = "0")
    private int originPrice;

    @ColumnInfo(name = "sell_price", defaultValue = "0")
    private int sellPrice;

    @ColumnInfo(defaultValue = "0")
    private int quantity;

    @ColumnInfo(name = "create_date", defaultValue = "CURRENT_TIMESTAMP")
    private String createDate;

    @ColumnInfo(name = "ship_date")
    private String shipDate;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
