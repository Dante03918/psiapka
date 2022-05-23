package com.dante.psiapka.configurations;

import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.dante.psiapka.idao.BreedDao;
import com.dante.psiapka.idao.DogDao;
import com.dante.psiapka.idao.HeatDao;
import com.dante.psiapka.idao.MatingDao;
import com.dante.psiapka.idao.MedicalTestDao;
import com.dante.psiapka.idao.PhotoDao;
import com.dante.psiapka.idao.ProgesteroneTestDao;
import com.dante.psiapka.idao.ThumbnailFileDao;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.Heat;
import com.dante.psiapka.model.Mating;
import com.dante.psiapka.model.MedicalTest;
import com.dante.psiapka.model.Photo;
import com.dante.psiapka.model.ProgesteroneTest;
import com.dante.psiapka.model.ThumbnailFile;

@androidx.room.Database(entities = {
        Breed.class,
        Dog.class,
        Heat.class,
        Mating.class,
        MedicalTest.class,
        Photo.class,
        ProgesteroneTest.class,
        ThumbnailFile.class}, version = 1)
@TypeConverters(com.dante.psiapka.utils.TypeConverters.class)
public abstract class Database extends RoomDatabase {
    public abstract BreedDao breedDao();
    public abstract DogDao dogDao();
    public abstract HeatDao heatDao();
    public abstract MatingDao matingDao();
    public abstract MedicalTestDao medicalTestDao();
    public abstract PhotoDao photoDao();
    public abstract ProgesteroneTestDao progesteroneTestDao();
    public abstract ThumbnailFileDao thumbnailFileDao();


    //Każde DAO musi mieć swoją abstrakcyjną metodę, zwracającą Obiekt tego DAO
}
