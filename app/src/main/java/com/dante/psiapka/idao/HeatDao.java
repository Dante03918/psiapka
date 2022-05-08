package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.dante.psiapka.model.Heat;

import java.util.List;

@Dao
public interface HeatDao {
    @Query("SELECT * FROM heat")
    List<Heat> getHeats();

    @Insert
    void insertHeat(Heat heat);

    @Delete
    void deleteHeat(int id);
}
