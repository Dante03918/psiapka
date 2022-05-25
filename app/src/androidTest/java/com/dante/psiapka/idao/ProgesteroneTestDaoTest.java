package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.ProgesteroneTest;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

@RunWith(AndroidJUnit4.class)
public class ProgesteroneTestDaoTest extends TestCase {

    public Database database;
    public InitDB initDB;
    public ProgesteroneTestDao progesteroneTestDao;

    @Before
    public void setUp(){
        initDB = new InitDB();
        database = initDB.initDB();
        progesteroneTestDao = database.progesteroneTestDao();
    }

    @Test
    public void insertAndGetProgesteroneTestTest(){
        assertEquals(initDB.progesteroneTestForInsert, progesteroneTestDao.getProgesteroneTests().get(0));
    }

    @Test
    public void updateProgesteroneTestTest(){
        ProgesteroneTest progesteroneTestForUpdate = new ProgesteroneTest(1,1, new Date(9999999999L), 1.7);
        assertEquals(1, progesteroneTestDao.updateProgesteroneTest(progesteroneTestForUpdate));
    }

    @Test
    public void deleteProgesteroneTestTest(){
        assertEquals(1, progesteroneTestDao.deleteProgesteroneTest(new ProgesteroneTest(1,1, new Date(9999999999L), 1.7)));
    }
}
