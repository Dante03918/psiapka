package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.Mating;

import java.util.List;

@Dao
public interface MatingDao {
    @Query("SELECT * FROM mating")
    List<Mating> getMatings();

    @Insert
    void insertMating(Mating mating);

    @Update
    void updateMating(Mating mating);

    @Query("DELETE FROM mating WHERE id = :id")
    int deleteMatingById(int id);  //  IllegalArgumentException !!! Usunąć można encję po ID a nie samo ID

    @Delete
    int deleteMating(Mating mating);
}
