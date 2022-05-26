package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DogAndMedicalTestTest extends TestCase {

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
    public void getDogAndMedicalTestTest(){
        assertEquals(dogDao.getDogAndMedicalTest().get(0).medicalTests.get(0), initDB.medicalTestForInsert);
    }
}
