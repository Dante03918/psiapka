package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.dante.psiapka.model.Dog;

import java.util.List;

@Dao
public interface DogDao {

    @Query("SELECT * FROM dog")
    List<Dog> getDogs();

    @Insert
    void insertDog(Dog dog);

//    @Delete
//    void deleteDog(int id);  //  IllegalArgumentException !!! Usunąć można encję po ID a nie samo ID
}
