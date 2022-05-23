package com.dante.psiapka.idao;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.model.BreedAndDog;
import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.Gender;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@RunWith(AndroidJUnit4.class)
public class DbTests {

    public Database database;
    public BreedDao breedDao;
    public DogDao dogDao;
    public Dog testDog;
    public Breed breedTest;


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
        breedTest = new Breed("Chin", null);

        breedDao.insertBreed(breedTest);
        dogDao.insertDog(testDog);
    }

    @Test
    public void getDogsWithBreeds(){

        List<BreedAndDog> breedAndDog;
        breedAndDog = breedDao.breedsWithDogsList();

        assertFalse(breedAndDog.get(0).dogs.isEmpty());

    }


    //DogDao tests

    @Test
    public void dogInsertTest(){

        assertEquals(testDog, dogDao.getDogs().get(0));
    }

    @Test
    public void updateDogEntity(){
        dogDao.updateDog(new Dog(1,
                1,
                "PedigreeName",
                "Frania",
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
                ""));
        assertEquals("Frania", dogDao.getDogs().stream()
                .map(el -> el.name)
                .filter(el -> el.equals("Frania"))
                .findFirst()
                .map(el -> el.toString())
                .orElse(""));


    }

    @Test
    public void deleteDogTest(){
        assertEquals(1, dogDao.deleteDog(testDog.id));
    }

}
