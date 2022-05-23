package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.Breed;
import com.dante.psiapka.model.BreedAndDog;
import com.dante.psiapka.model.Dog;

import java.util.List;

@Dao
public interface BreedDao {

    @Query("SELECT * FROM breed")
    List<Breed> getBreeds();

    @Insert
    void insertBreed(Breed breed);

    @Delete
    void deleteBreed(Breed breed);  // IllegalArgumentException !!! Usunąć można encję po ID a nie samo ID

    @Update
    int updateBreed(Breed breed);

    @Query("SELECT * FROM breed")
    List<BreedAndDog> breedsWithDogsList();

    //TODO dodać resztę instrukcji SQL
}
