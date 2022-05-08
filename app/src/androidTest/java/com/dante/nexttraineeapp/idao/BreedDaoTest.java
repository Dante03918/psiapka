package com.dante.nexttraineeapp.idao;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.dante.nexttraineeapp.configurations.Database;
import junit.framework.TestCase;
import model.Breed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class BreedDaoTest extends TestCase {

    private Database testDb;
    private BreedDao breedDao;

    @Before
    public void dbSetup(){
        Context context = ApplicationProvider.getApplicationContext();
        testDb = Room.inMemoryDatabaseBuilder(context, Database.class).build();
        breedDao = testDb.breedDao();

        breedDao.insertBreed(new Breed("Chinek", "URL://chinek"));
    }

    @Test
    public void testGetBreeds() {
        List<Breed> retrieved = breedDao.getBreeds();

       Breed breed = retrieved.get(0);

       assertEquals("Chinek", breed.getName());
    }
}