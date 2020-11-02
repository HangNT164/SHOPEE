package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM product")
    List<Product> getAll();

    @Query("SELECT * FROM product WHERE id = :id")
    Product getOne(int id);

    @Insert
    void add(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
