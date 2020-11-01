package com.dao;

import androidx.room.Dao;
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
    boolean add(SubCategory subCategory);

    @Update
    boolean update(SubCategory subCategory);

    @Query("UPDATE sub_category SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
