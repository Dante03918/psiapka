package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Heat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.TestCase;

import java.util.Date;

@RunWith(AndroidJUnit4.class)
public class HeatDaoTest extends TestCase {

    public Database database;
    public InitDB initDB;

    @Before
    public void setUp() {
       initDB = new InitDB();
       database = initDB.initDB();
    }

    @Test
    public void insertAndGetHeatTest(){

        assertEquals(initDB.heatForInsert, database.heatDao().getHeats().get(0));
    }
    @Test
    public void updateHeatTest(){
        Heat heatForUpdate = new Heat(1, 1, new Date(System.currentTimeMillis()));
        database.heatDao().updateHeat(heatForUpdate);
        assertEquals(heatForUpdate, database.heatDao().getHeats().get(0));
    }
    @Test
    public void deleteHeatTest(){

        assertEquals(1, database.heatDao().deleteHeatById(1));
    }
}
