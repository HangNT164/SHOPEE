package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment_detail")
public class PaymentDetail {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo(name = "payment_detail_name")
    private String paymentDetailName;

    public PaymentDetail(int id, String paymentDetailName) {
        this.id = id;
        this.paymentDetailName = paymentDetailName;
    }

    public PaymentDetail() {
    }

    public PaymentDetail(String paymentDetailName) {
        this.paymentDetailName = paymentDetailName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentDetailName() {
        return paymentDetailName;
    }

    public void setPaymentDetailName(String paymentDetailName) {
        this.paymentDetailName = paymentDetailName;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "id=" + id +
                ", paymentDetailName='" + paymentDetailName + '\'' +
                '}';
    }
}
