package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.ImageSubCate;

import java.util.List;

@Dao
public interface ImageSubcateDao {
    @Query("SELECT * FROM image_subcate")
    List<ImageSubCate> getAll();

    @Query("SELECT * FROM image_subcate WHERE id = :id")
    ImageSubCate getOne(int id);

    @Insert
    void add(ImageSubCate imageSubCate);

    @Update
    void update(ImageSubCate imageSubCate);

    @Delete
    void delete(ImageSubCate imageSubCate);
}
