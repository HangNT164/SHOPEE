package com.dao;

import androidx.room.Dao;
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
    boolean add(Product product);

    @Update
    boolean update(Product product);

    @Query("UPDATE product SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
