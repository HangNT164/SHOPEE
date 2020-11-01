package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Image;

import java.util.List;

@Dao
public interface ImageDao {
    @Query("SELECT * FROM image")
    List<Image> getAll();

    @Query("SELECT * FROM image WHERE id = :id")
    Image getOne(int id);

    @Insert
    boolean add(Image image);

    @Update
    boolean update(Image image);

    @Query("UPDATE image SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
