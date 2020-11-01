package com.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.Account;

import java.util.List;

@Dao
public interface AccountDao {
    @Query("SELECT * FROM account")
    List<Account> getAll();

    @Query("SELECT * FROM account WHERE id = :id")
    Account getOne(int id);

    @Insert
    boolean add(Account account);

    @Update
    boolean update(Account account);

    @Query("UPDATE account SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
