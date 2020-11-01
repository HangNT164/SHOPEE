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
@Entity(tableName = "image")
public class Image {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo
    private String imageLink;

    @ColumnInfo(defaultValue = "0")
    private boolean cover;

    @ColumnInfo(defaultValue = "0")
    private boolean deleted;
}
