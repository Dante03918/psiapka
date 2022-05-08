package com.dante.nexttraineeapp.configurations;

import androidx.room.RoomDatabase;
import com.dante.nexttraineeapp.idao.BreedDao;
import model.Breed;

@androidx.room.Database(entities = {Breed.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract BreedDao breedDao();

    //Każde DAO musi mieć swoją abstrakcyjną metodę, zwracającą Obiekt tego DAO
}
