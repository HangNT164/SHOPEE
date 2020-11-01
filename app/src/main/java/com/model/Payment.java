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
@Entity(tableName = "payment")
public class Payment {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ForeignKey(entity = PaymentDetail.class, parentColumns = {"id"}, childColumns = {"payment_detail_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "payment_detail_id")
    private int paymentDetailID;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
