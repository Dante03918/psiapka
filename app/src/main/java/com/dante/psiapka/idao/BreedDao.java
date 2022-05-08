package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.dante.psiapka.model.Breed;

import java.util.List;

@Dao
public interface BreedDao {

    @Query("SELECT * FROM breed")
    List<Breed> getBreeds();

    @Insert
    void insertBreed(Breed breed);

    @Delete
    void deleteBreed(int id);

    //TODO dodać resztę instrukcji SQL
}
