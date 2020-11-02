package com.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.model.ImageAvatar;

import java.util.List;

@Dao
public interface ImageAvatarDao {
    @Query("SELECT * FROM image_avatar")
    List<ImageAvatar> getAll();

    @Query("SELECT * FROM image_avatar WHERE id = :id")
    ImageAvatar getOne(int id);

    @Insert
    void add(ImageAvatar imageAvatar);

    @Update
    void update(ImageAvatar imageAvatar);

    @Delete
    void delete(ImageAvatar imageAvatar);
}
