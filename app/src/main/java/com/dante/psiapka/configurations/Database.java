package com.dante.psiapka.configurations;

import android.content.Context;

import androidx.room.Room;
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        private static volatile Database INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static Database getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database.class, "psiapka_db").build();
                }
            }
        }
        return INSTANCE;
    }
}
