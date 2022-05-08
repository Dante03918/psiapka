package com.dante.psiapka.configurations;

import androidx.room.RoomDatabase;
import com.dante.psiapka.idao.BreedDao;
import com.dante.psiapka.model.Breed;

@androidx.room.Database(entities = {Breed.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract BreedDao breedDao();

    //Każde DAO musi mieć swoją abstrakcyjną metodę, zwracającą Obiekt tego DAO
}
