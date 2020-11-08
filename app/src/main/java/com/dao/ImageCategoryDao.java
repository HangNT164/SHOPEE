package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.ImageCategory;

import java.util.List;

@Dao
public interface ImageCategoryDao {
    @Query("SELECT * FROM image_category")
    List<ImageCategory> getAll();

    @Query("SELECT * FROM image_category WHERE id = :id")
    ImageCategory getOne(int id);

    @Insert
    void add(ImageCategory imageCategory);

    @Update
    void update(ImageCategory imageCategory);

    @Delete
    void delete(ImageCategory imageCategory);
}
