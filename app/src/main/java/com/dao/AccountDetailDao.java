package com.dao;

import androidx.room.Dao;
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
    boolean add(AccountDetail accountDetail);

    @Update
    boolean update(AccountDetail accountDetail);

    @Query("UPDATE account_detail SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
