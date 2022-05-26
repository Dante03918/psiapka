package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class HeatAndProgesteroneTestTest extends TestCase {

    public Database database;
    public InitDB initDB;
    public HeatDao heatDao;

    @Before
    public void setUp(){
        initDB = new InitDB();
        database = initDB.initDB();
        heatDao = database.heatDao();
    }

    @Test
    public void getHeatAndProgesteroneTestTest(){
        assertEquals(heatDao.getHeatAndProgesteroneTest().get(0).progesteroneTests.get(0), initDB.progesteroneTestForInsert);
    }
}
