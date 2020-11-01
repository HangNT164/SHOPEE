package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.StatusOrder;

import java.util.List;

@Dao
public interface StatusOrderDao {
    @Query("SELECT * FROM status_order")
    List<StatusOrder> getAll();

    @Query("SELECT * FROM status_order WHERE id = :id")
    StatusOrder getOne(int id);

    @Insert
    boolean add(StatusOrder statusOrder);

    @Update
    boolean update(StatusOrder statusOrder);

    @Query("UPDATE status_order SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
