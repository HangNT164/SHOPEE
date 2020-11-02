package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.AccountDetail;

import java.util.List;

@Dao
public interface AccountDetailDao {
    @Query("SELECT * FROM account_detail")
    List<AccountDetail> getAll();

    @Query("SELECT * FROM account_detail WHERE id = :id")
    AccountDetail getOne(int id);

    @Insert
    void add(AccountDetail accountDetail);

    @Update
    void update(AccountDetail accountDetail);

    @Delete
    void delete(AccountDetail accountDetail);
}
