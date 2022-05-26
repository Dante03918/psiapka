package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.DogAndHeat;
import com.dante.psiapka.model.DogWithMatingAndHeat;

import java.util.List;

@Dao
public interface DogDao {

    @Query("SELECT * FROM dog")
    List<Dog> getDogs();

    @Insert
    void insertDog(Dog dog);

    @Update
    void updateDog(Dog dog);

    @Query("DELETE FROM dog WHERE id = :id")
    int deleteDogById(int id);  //  IllegalArgumentException !!! Usunąć można encję po ID a nie samo ID

    @Delete
    int deleteDog(Dog dog);

    @Query("SELECT * FROM dog")
     List<DogAndHeat> dogsWithHeats();

    @Query("SELECT * FROM dog")
     List<DogWithMatingAndHeat> dogWithMatingAndHeat();
}
