package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.ThumbnailFile;

import java.util.List;

@Dao
public interface ThumbnailFileDao {
    @Query("SELECT * FROM thumbnail_file")
    List<ThumbnailFile> getThumbnailFiles();

    @Insert
    void insertThumbnailFile(ThumbnailFile thumbnailFile);

    @Update
    int updateThumbnailFile(ThumbnailFile thumbnailFile);

    @Query("DELETE FROM thumbnail_file WHERE id = :id")
    int deleteThumbnailFileById(int id);

    @Delete
    int deleteThumbnailFile(ThumbnailFile thumbnailFile);

}
