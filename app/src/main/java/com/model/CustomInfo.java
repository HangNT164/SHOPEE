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
@Entity(tableName = "custom_info")
public class CustomInfo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo(name = "custom_name")
    private String customerName;

    @ColumnInfo
    private String mobile;

    @ColumnInfo
    private String address;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
