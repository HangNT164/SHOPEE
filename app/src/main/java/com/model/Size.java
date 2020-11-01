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
@Entity(tableName = "size")
public class Size {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private  int id;

    @ColumnInfo(name = "size_name")
    private String sizeName;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
