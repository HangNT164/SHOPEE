package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
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
    void add(Order order);

    @Update
    void update(Order order);

    @Delete
    void delete(Order order);
}
