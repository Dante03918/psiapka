package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DogWithMatingAndHeatRelationTest extends TestCase {

    public Database database;
    public InitDB initDB;
    public DogDao dogDao;

    @Before
    public void setUp(){
        initDB = new InitDB();
        database = initDB.initDB();
        dogDao = database.dogDao();
    }

    @Test
    public void getHeatFromDogWithMatingAndHeatTest(){
        assertEquals(dogDao.getDogWithMatingAndHeat().get(0).heats.get(0), initDB.heatForInsert);
    }

    @Test
    public void getMatingFromDogWithMatingAndHeatTest(){
        assertEquals(dogDao.getDogWithMatingAndHeat().get(0).matings.get(0), initDB.matingForInsert);
    }
}
