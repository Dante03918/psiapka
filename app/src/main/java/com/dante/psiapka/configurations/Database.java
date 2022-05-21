package com.dante.psiapka.configurations;

import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.dante.psiapka.idao.BreedDao;
import com.dante.psiapka.idao.DogDao;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.model.Dog;

@androidx.room.Database(entities = {Breed.class, Dog.class}, version = 1)
@TypeConverters(com.dante.psiapka.utils.TypeConverters.class)
public abstract class Database extends RoomDatabase {
    public abstract BreedDao breedDao();
    public abstract DogDao dogDao();

    //Każde DAO musi mieć swoją abstrakcyjną metodę, zwracającą Obiekt tego DAO
}
