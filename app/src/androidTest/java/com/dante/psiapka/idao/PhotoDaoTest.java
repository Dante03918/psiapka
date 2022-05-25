package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Photo;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PhotoDaoTest extends TestCase {

    public Database database;
    public InitDB initDB;
    public PhotoDao photoDao;

    @Before
    public void setUp(){
        initDB = new InitDB();
        database = initDB.initDB();
        photoDao = database.photoDao();
    }

    @Test
    public void insertAndGetPhotoTest(){
        assertEquals(initDB.photoForInsert, photoDao.getPhotos().get(0));
    }

    @Test
    public void updatePhotoTest(){
        Photo photoForUpdate = new Photo(1,1, "UpdatedPhotoURL");
        assertEquals(1, photoDao.updatePhoto(photoForUpdate));
    }

    @Test
    public void deletePhotoTest(){
        assertEquals(1, photoDao.deletePhoto(new Photo(1,1, "UpdatedPhotoURL")));
    }
}
