package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.SubCategory;

import java.util.List;

@Dao
public interface SubCategoryDao {
    @Query("SELECT * FROM sub_category")
    List<SubCategory> getAll();

    @Query("SELECT * FROM sub_category WHERE id = :id")
    SubCategory getOne(int id);

    @Insert
    void add(SubCategory subCategory);

    @Update
    void update(SubCategory subCategory);

    @Delete
    void delete(SubCategory subCategory);
}
