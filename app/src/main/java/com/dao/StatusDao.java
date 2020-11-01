package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Status;

import java.util.List;

@Dao
public interface StatusDao {
    @Query("SELECT * FROM status")
    List<Status> getAll();

    @Query("SELECT * FROM status WHERE id = :id")
    Status getOne(int id);

    @Insert
    boolean add(Status status);

    @Update
    boolean update(Status status);

    @Query("UPDATE status SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
