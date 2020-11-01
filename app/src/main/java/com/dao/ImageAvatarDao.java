package com.dao;

import androidx.room.Dao;
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
    boolean add(ImageAvatar imageAvatar);

    @Update
    boolean update(ImageAvatar imageAvatar);

    @Query("UPDATE image_avatar SET deleted = 1 WHERE id = :id")
    boolean delete(int id);
}
