package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@Entity(tableName = "payment_detail")
public class PaymentDetail {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private  int id;

    @ColumnInfo(name = "payment_detail_name")
    private String paymentDetailName;

    @ColumnInfo(defaultValue = "0")
    private  boolean deleted;
}
