package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Mating;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

@RunWith(AndroidJUnit4.class)
public class MatingDaoTest extends TestCase {

    public Database database;
    public InitDB initDB;
    public MatingDao matingDao;

    @Before
    public void setUp(){
        initDB = new InitDB();
        database = initDB.initDB();
        matingDao = database.matingDao();
    }

    @Test
    public void insertMatingTest(){
        assertEquals(initDB.matingForInsert, matingDao.getMatings().get(0));
    }

    @Test
    public void updateMatingTest(){
        Mating matingForUpdate = new Mating(1, 1, new Date(System.currentTimeMillis()), 1, "Update");
        assertEquals(1, matingDao.updateMating(matingForUpdate));
    }

    @Test
    public void deleteMatingTest(){
        assertEquals(1, matingDao.deleteMating(new Mating(1, 1, new Date(System.currentTimeMillis()), 2, "Update")));
    }
}
