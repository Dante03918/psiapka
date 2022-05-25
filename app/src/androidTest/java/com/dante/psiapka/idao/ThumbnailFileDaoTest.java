package com.dante.psiapka.idao;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.ThumbnailFile;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ThumbnailFileDaoTest extends TestCase {

    public Database database;
    public InitDB initDB;
    public ThumbnailFileDao thumbnailFileDao;

    @Before
    public void setUp(){
        initDB = new InitDB();
        database = initDB.initDB();
        thumbnailFileDao = database.thumbnailFileDao();
    }

    @Test
    public void insertAndGetThumbnailFileTest(){
        assertEquals(initDB.thumbnailFileForInsert, thumbnailFileDao.getThumbnailFiles().get(0));
    }

    @Test
    public void updateThumbnailFileTest(){
        ThumbnailFile thumbnailFileForUpdate = new ThumbnailFile(1, 1, "UpdatedThumbnailUrl");
        assertEquals(1, thumbnailFileDao.updateThumbnailFile(thumbnailFileForUpdate));
    }

    @Test
    public void deleteThumbnailFileTest(){
        assertEquals(1, thumbnailFileDao.deleteThumbnailFile(new ThumbnailFile(1, 1, "UpdatedThumbnailUrl")));
    }
}
