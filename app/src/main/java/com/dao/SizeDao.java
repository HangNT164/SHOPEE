package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Size;

import java.util.List;

@Dao
public interface SizeDao {
    @Query("SELECT * FROM size")
    List<Size> getAll();

    @Query("SELECT * FROM size WHERE id = :id")
    Size getOne(int id);

    @Insert
    boolean add(Size size);

    @Update
    boolean update(Size size);

    @Query("UPDATE size SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
