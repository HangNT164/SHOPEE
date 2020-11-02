package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
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
    void add(StatusOrder statusOrder);

    @Update
    void update(StatusOrder statusOrder);

    @Delete
    void delete(StatusOrder statusOrder);
}
