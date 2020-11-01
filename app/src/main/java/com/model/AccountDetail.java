package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@Entity(tableName = "account_detail")
public class AccountDetail {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String mobile;

    @ColumnInfo(defaultValue = "0")
    private boolean gender;

    @ColumnInfo
    private String address;

    @ColumnInfo(name = "create_date", defaultValue = "CURRENT_TIMESTAMP")
    private String createDate;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
