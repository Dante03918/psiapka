package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.Gender;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.TestCase;

import java.util.Date;

@RunWith(AndroidJUnit4.class)
public class DogDaoTest extends TestCase {

    public Database database;
    public InitDB initDB;

    @Before
    public void setUp(){
        initDB = new InitDB();
        database = initDB.initDB();
    }

    @Test
    public void dogInsertAndGetTest(){

        assertEquals(initDB.dogForInsert, database.dogDao().getDogs().get(0));
    }

    @Test
    public void updateDogEntity(){
        database.dogDao().updateDog(new Dog(1,
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
                5,
                "",
                7,
                "",
                ""));
        assertEquals("Frania", database.dogDao().getDogs().stream()
                .map(el -> el.name)
                .filter(el -> el.equals("Frania"))
                .findFirst()
                .map(el -> el.toString())
                .orElse(""));


    }

    @Test
    public void deleteDogTest(){
        assertEquals(1, database.dogDao().deleteDogById(initDB.dogForInsert.id));
    }


    // DogAndHeat tests

//    @Test
//    public void getDogWithHeats(){
//        database.heatDao().insertHeat(new Heat(1, new Date(System.currentTimeMillis())));
//
//        List<DogAndHeat> dogAndHeats = dogDao.dogsWithHeats();        //Test do przeniesienia !
//        assertFalse(dogAndHeats.get(0).heatList.isEmpty());
//    }
}
