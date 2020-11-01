package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@Entity(tableName = "account")
public class Account {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ForeignKey(entity = AccountDetail.class, parentColumns = {"id"}, childColumns = {"account_detail_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "account_detail_id")
    private int accountDetailID;

    @ForeignKey(entity = Role.class, parentColumns = {"id"}, childColumns = {"role_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "role_id")
    private int roleID;

    @ColumnInfo
    private String email;

    @ColumnInfo
    private String password;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
