package com.dante.psiapka.idao;

import static org.junit.Assert.assertFalse;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.model.BreedAndDog;
import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.Gender;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;
@RunWith(AndroidJUnit4.class)
public class DogWithBreedRelationTest {

    public Database database;
    public BreedDao breedDao;
    public DogDao dogDao;
    public Dog testDog;


    @Before
    public void setUp(){
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, Database.class).build();
        breedDao = database.breedDao();
        dogDao = database.dogDao();
        testDog = new Dog(1,
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
                "",
                "",
                "",
                "",
                "");

        breedDao.insertBreed(new Breed("Chin", null));
        dogDao.insertDog(testDog);
    }

    @Test
    public void getDogsWithBreeds(){

        List<BreedAndDog> breedAndDog;
        breedAndDog = breedDao.breedsWithDogsList();

        assertFalse(breedAndDog.get(0).dogs.isEmpty());

    }

    @After
    public  void shutDown(){
        database.close();
    }
}
