package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "size")
public class Size {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo(name = "size_name")
    private String sizeName;

    public Size(int id, String sizeName) {
        this.id = id;
        this.sizeName = sizeName;
    }

    public Size() {
    }

    public Size(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", sizeName='" + sizeName + '\'' +
                '}';
    }
}
