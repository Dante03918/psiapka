package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.DogAndHeat;
import com.dante.psiapka.model.ProgesteroneTest;

import java.util.List;

@Dao
public interface ProgesteroneTestDao {

    @Query("SELECT * FROM progesterone_test")
    List<ProgesteroneTest> getProgesteroneTests();

    @Insert
    void insertProgesteroneTest(ProgesteroneTest progesteroneTest);

    @Update
    int updateProgesteroneTest(ProgesteroneTest progesteroneTest);

    @Query("DELETE FROM progesterone_test WHERE id = :id")
    int deleteProgesteroneTestById(int id);  //  IllegalArgumentException !!! Usunąć można encję po ID a nie samo ID

    @Delete
    int deleteProgesteroneTest(ProgesteroneTest progesteroneTest);

}
