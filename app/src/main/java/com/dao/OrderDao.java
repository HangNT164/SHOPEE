package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Order;

import java.util.List;

@Dao
public interface OrderDao {
    @Query("SELECT * FROM `order`")
    List<Order> getAll();

    @Query("SELECT * FROM `order` WHERE id = :id")
    Order getOne(int id);

    @Insert
    boolean add(Order order);

    @Update
    boolean update(Order order);

    @Query("UPDATE `order` SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
