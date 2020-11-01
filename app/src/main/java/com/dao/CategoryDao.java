package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM category")
    List<Category> getAll();

    @Query("SELECT * FROM category WHERE id = :id")
    Category getOne(int id);

    @Insert
    boolean add(Category category);

    @Update
    boolean update(Category category);

    @Query("UPDATE category SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
