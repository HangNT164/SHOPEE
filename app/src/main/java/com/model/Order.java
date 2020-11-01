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
@Entity(tableName = "order")
public class Order {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ForeignKey(entity = Payment.class, parentColumns = {"id"}, childColumns = {"payment_detail_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "payment_detail_id")
    private int paymentDetailID;

    @ForeignKey(entity = StatusOrder.class, parentColumns = {"id"}, childColumns = {"status_order_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "status_order_id")
    private int statusOrderID;

    @ForeignKey(entity = CustomInfo.class, parentColumns = {"id"}, childColumns = {"custom_info_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "custom_info_id")
    private int customInfoID;

    @ForeignKey(entity = AccountDetail.class, parentColumns = {"id"}, childColumns = {"account_detail_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "account_detail_id")
    private int accountDetailID;

    @ColumnInfo(name = "total_price")
    private int totalPrice;

    @ColumnInfo(name = "note")
    private String note;

    @ColumnInfo(name = "create_date", defaultValue = "CURRENT_TIMESTAMP")
    private String createDate;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
