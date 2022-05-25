package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.Heat;

import java.util.List;

@Dao
public interface HeatDao {
    @Query("SELECT * FROM heat")
    List<Heat> getHeats();

    @Insert
    void insertHeat(Heat heat);

    @Update
    void updateHeat(Heat heat);

    @Query("DELETE FROM heat WHERE id = :id")
    int deleteHeatById(int id);

    @Delete
    int deleteHeat(Heat heat);
}
