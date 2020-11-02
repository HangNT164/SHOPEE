package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Brand;

import java.util.List;

@Dao
public interface BrandDao {
    @Query("SELECT * FROM brand")
    List<Brand> getAll();

    @Query("SELECT * FROM brand WHERE id = :id")
    Brand getOne(int id);

    @Insert
    void add(Brand brand);

    @Update
    void update(Brand brand);

    @Delete
    void delete(Brand brand);
}