package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Evaluate;

import java.util.List;

@Dao
public interface EvaluateDao {
    @Query("SELECT * FROM evaluate")
    List<Evaluate> getAll();

    @Query("SELECT * FROM evaluate WHERE id = :id")
    Evaluate getOne(int id);

    @Insert
    boolean add(Evaluate evaluate);

    @Update
    boolean update(Evaluate evaluate);

    @Query("UPDATE evaluate SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
