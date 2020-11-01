package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.PaymentDetail;

import java.util.List;

@Dao
public interface PaymentDetailDao {
    @Query("SELECT * FROM payment_detail")
    List<PaymentDetail> getAll();

    @Query("SELECT * FROM payment_detail WHERE id = :id")
    PaymentDetail getOne(int id);

    @Insert
    boolean add(PaymentDetail paymentDetail);

    @Update
    boolean update(PaymentDetail paymentDetail);

    @Query("UPDATE payment_detail SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
