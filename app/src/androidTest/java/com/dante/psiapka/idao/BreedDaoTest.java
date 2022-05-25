package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;

import junit.framework.TestCase;

import com.dante.psiapka.model.Breed;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BreedDaoTest extends TestCase {

     Database testDb;
     BreedDao breedDao;
     InitDB initDB;

    @Before
    public void dbSetup() {
        initDB =  new InitDB();
        testDb = initDB.initDB();
        breedDao = testDb.breedDao();

        breedDao.insertBreed(new Breed("Chinek", "URL://chinek"));
    }

    @Test
    public void testInsertAndGetBreed() {
        assertEquals(initDB.breedForInsert, testDb.breedDao().getBreeds().get(0));
    }

    @Test
    public void testUpdateBreed(){
        Breed forUpdate = new Breed(1,"Lhasa", "URL://lhasa");
        assertEquals(1, breedDao.updateBreed(forUpdate));
    }

    @Test
    public void testDeleteBreed(){
        breedDao.deleteBreed(new Breed(1,"Chinek", "URL://chinek"));
        assertEquals(1, breedDao.getBreeds().size());
    }

    @After
    public void shutDown(){
       testDb.close();
    }
}