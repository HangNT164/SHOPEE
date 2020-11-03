package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image")
public class Image {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo(name = "image_link")
    private String imageLink;

    @ColumnInfo(defaultValue = "0")
    private boolean cover;

    public Image(int id, String imageLink, boolean cover) {
        this.id = id;
        this.imageLink = imageLink;
        this.cover = cover;
    }

    public Image(String imageLink, boolean cover) {
        this.imageLink = imageLink;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean isCover() {
        return cover;
    }

    public void setCover(boolean cover) {
        this.cover = cover;
    }

    public Image() {
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageLink='" + imageLink + '\'' +
                ", cover=" + cover +
                '}';
    }
}
