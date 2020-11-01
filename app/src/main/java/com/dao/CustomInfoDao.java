package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.CustomInfo;

import java.util.List;

@Dao
public interface CustomInfoDao {
    @Query("SELECT * FROM custom_info")
    List<CustomInfo> getAll();

    @Query("SELECT * FROM custom_info WHERE id = :id")
    CustomInfo getOne(int id);

    @Insert
    boolean add(CustomInfo customInfo);

    @Update
    boolean update(CustomInfo customInfo);

    @Query("UPDATE custom_info SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
