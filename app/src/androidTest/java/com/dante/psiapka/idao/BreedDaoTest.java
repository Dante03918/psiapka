package com.dante.psiapka.idao;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;

import junit.framework.TestCase;

import com.dante.psiapka.model.Breed;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(AndroidJUnit4.class)
public class BreedDaoTest extends TestCase {

    private Database testDb;
    private BreedDao breedDao;

    @Before
    public void dbSetup() {
        Context context = ApplicationProvider.getApplicationContext();
        testDb = Room.inMemoryDatabaseBuilder(context, Database.class).build();
        breedDao = testDb.breedDao();

        breedDao.insertBreed(new Breed("Chinek", "URL://chinek"));
    }

    @Test
    public void testInsertBreed() {

        Breed forInsert = new Breed("Lhasa", "URL://lhasa");
        breedDao.insertBreed(forInsert);

        assertEquals(Collections.singletonList(forInsert), breedDao.getBreeds().stream()
                .filter(el -> el.name.equals("Lhasa"))
                .collect(Collectors.toList()));
    }

    @Test
    public void testGetBreeds() {
        List<Breed> retrieved = breedDao.getBreeds();
        Breed breed = retrieved.get(0);
        assertEquals("Chinek", breed.getName());
    }

    @Test
    public void testUpdateBreed(){
        Breed forUpdate = new Breed(1,"Lhasa", "URL://lhasa");
        assertEquals(1, breedDao.updateBreed(forUpdate));
    }

    @Test
    public void testDeleteBreed(){
        breedDao.deleteBreed(new Breed(1,"Chinek", "URL://chinek"));
        assertEquals(0, breedDao.getBreeds().size());
    }

    @After
    public void shutDown(){
        testDb.close();
    }

}