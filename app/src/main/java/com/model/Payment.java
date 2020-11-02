package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment")
public class Payment {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ForeignKey(entity = PaymentDetail.class, parentColumns = {"id"}, childColumns = {"payment_detail_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "payment_detail_id")
    private int paymentDetailID;

    public Payment(int id, int paymentDetailID) {
        this.id = id;
        this.paymentDetailID = paymentDetailID;
    }

    public Payment(int paymentDetailID) {
        this.paymentDetailID = paymentDetailID;
    }

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentDetailID() {
        return paymentDetailID;
    }

    public void setPaymentDetailID(int paymentDetailID) {
        this.paymentDetailID = paymentDetailID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentDetailID=" + paymentDetailID +
                '}';
    }
}
