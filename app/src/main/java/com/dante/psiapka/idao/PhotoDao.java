package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.DogAndHeat;
import com.dante.psiapka.model.Photo;

import java.util.List;

@Dao
public interface PhotoDao {

    @Query("SELECT * FROM photo")
    List<Photo> getPhotos();

    @Insert
    void insertPhoto(Photo photo);

    @Update
    int updatePhoto(Photo photo);

    @Query("DELETE FROM photo WHERE id = :id")
    int deletePhotoById(int id);

    @Delete
    int deletePhoto(Photo photo);

}
