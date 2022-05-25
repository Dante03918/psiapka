package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.MedicalTest;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MedicalTestDaoTest extends TestCase {

    public Database database;
    public InitDB initDB;
    public MedicalTestDao medicalTestDao;

    @Before
    public void setUp(){
        initDB = new InitDB();
        database = initDB.initDB();
        medicalTestDao = database.medicalTestDao();
    }

    @Test
    public void insertAndGetTest(){
        assertEquals(initDB.medicalTestForInsert, medicalTestDao.getMedicalTest().get(0));
    }

    @Test
    public void updateMedicalTestTest(){
        MedicalTest medicalTestForUpdate = new MedicalTest(1,1, "updatedMedicalTestUrl");
        assertEquals(1, medicalTestDao.updateMedicalTest(medicalTestForUpdate));
    }

    @Test
    public void deleteMedicalTestTest(){
        assertEquals(1, medicalTestDao.deleteMedicalTest(medicalTestDao.getMedicalTest().get(0)));
    }
}
