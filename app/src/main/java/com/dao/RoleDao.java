package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Role;

import java.util.List;

@Dao
public interface RoleDao {
    @Query("SELECT * FROM role")
    List<Role> getAll();

    @Query("SELECT * FROM role WHERE id = :id")
    Role getOne(int id);

    @Insert
    boolean add(Role role);

    @Update
    boolean update(Role role);

    @Query("UPDATE role SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
