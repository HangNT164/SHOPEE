package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.OrderDetail;

import java.util.List;

@Dao
public interface OrderDetailDao {
    @Query("SELECT * FROM order_detail")
    List<OrderDetail> getAll();

    @Query("SELECT * FROM order_detail WHERE id = :id")
    OrderDetail getOne(int id);

    @Insert
    boolean add(OrderDetail orderDetail);

    @Update
    boolean update(OrderDetail orderDetail);

    @Query("UPDATE order_detail SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
