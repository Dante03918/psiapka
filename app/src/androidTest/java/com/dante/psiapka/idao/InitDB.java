package com.dante.psiapka.idao;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.Gender;
import com.dante.psiapka.model.Heat;
import com.dante.psiapka.model.Mating;
import com.dante.psiapka.model.MedicalTest;
import com.dante.psiapka.model.Photo;
import com.dante.psiapka.model.ProgesteroneTest;
import com.dante.psiapka.model.ThumbnailFile;

import org.junit.runner.RunWith;

import java.util.Date;

public class InitDB {

    public Database database;

    public Breed breedForInsert = new Breed("Chin", null);
    public Dog dogForInsert = new Dog(1,
            1,
            "PedigreeName",
            "Zosia",
            Gender.FEMALE,
            new Date(11111111111L),
            987654321,
            "",
            new Date(222222222L),
            new Date(2332343524L),
            "",
            "",
            "",
            2,
            "",
            3,
            "",
            "");
    public Heat heatForInsert = new Heat(1, new Date(System.currentTimeMillis() - 99999999999999L));
    public Mating matingForInsert = new Mating(1, new Date(99999999999999L), 1, "");
    public MedicalTest medicalTestForInsert = new MedicalTest(1, "medicalTestUrl");
    public Photo photoForInsert = new Photo(1, "photoURL");
    public ProgesteroneTest progesteroneTestForInsert = new ProgesteroneTest(1, new Date(9999999999L), 1.1);
    public ThumbnailFile thumbnailFileForInsert = new ThumbnailFile(1, "thumbnailUrl");

    public Database initDB(){

        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, Database.class).build();

        this.insertBreed();
        this.insertDog();
        this.insertHeat();
        this.insertMating();
        this.insertMedicalTest();
        this.insertPhoto();
        this.insertProgesteroneTest();
        this.insertThumbnailFile();

        return database;
    }

    public void insertBreed(){
        database.breedDao().insertBreed(breedForInsert);
    }
    public void insertDog(){
        database.dogDao().insertDog(dogForInsert);

    }
    public void insertHeat(){
        database.heatDao().insertHeat(heatForInsert);
    }
    public void insertMating(){
        database.matingDao().insertMating(matingForInsert);
    }
    public void insertMedicalTest(){
        database.medicalTestDao().insertMedicalTest(medicalTestForInsert);
    }
    public void insertPhoto(){
        database.photoDao().insertPhoto(photoForInsert);
    }
    public void insertProgesteroneTest(){
        database.progesteroneTestDao().insertProgesteroneTest(progesteroneTestForInsert);
    }
    public void insertThumbnailFile(){
        database.thumbnailFileDao().insertThumbnailFile(thumbnailFileForInsert);
    }
}
