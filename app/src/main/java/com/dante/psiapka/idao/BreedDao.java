package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.Breed;
import com.dante.psiapka.model.BreedAndDog;

import java.util.List;

@Dao
public interface BreedDao {

    @Query("SELECT * FROM breed")
    List<Breed> getBreeds();

    @Insert
    void insertBreed(Breed breed);

    @Delete
    void deleteBreed(Breed breed);

    @Query("DELETE FROM breed WHERE id = :id")
    void deleteBreedById(int id);

    @Update
    int updateBreed(Breed breed);

    @Query("SELECT * FROM breed")
    List<BreedAndDog> breedsWithDogsList();

    @Query("DELETE FROM breed")
    void deleteAllBreeds();


    //TODO dodać resztę instrukcji SQL
}
