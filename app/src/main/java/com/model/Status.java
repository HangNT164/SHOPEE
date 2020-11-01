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
@Entity(tableName = "status")
public class Status {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ForeignKey(entity = Product.class, parentColumns = {"id"}, childColumns = {"product_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "product_id")
    private int productID;

    @ColumnInfo(name = "description_status", defaultValue = "0")
    private int descriptionStatus;

    @ColumnInfo(name = "status_name")
    private String statusName;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
