package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.DogAndHeat;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DogAndHeatRelationTest extends TestCase {

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
    public void getDogAndHeatsTest(){
        DogAndHeat dogAndHeat = dogDao.dogsWithHeats().get(0);
        assertEquals(dogAndHeat.heatList.get(0), initDB.heatForInsert);
    }
}
