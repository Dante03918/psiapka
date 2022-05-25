package com.dante.psiapka.idao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dante.psiapka.model.Dog;
import com.dante.psiapka.model.DogAndHeat;
import com.dante.psiapka.model.MedicalTest;

import java.util.List;

@Dao
public interface MedicalTestDao {
    @Query("SELECT * FROM medical_test")
    List<MedicalTest> getMedicalTest();

    @Insert
    void insertMedicalTest(MedicalTest medicalTest);

    @Update
    int updateMedicalTest(MedicalTest medicalTest);

    @Query("DELETE FROM medical_test WHERE id = :id")
    int deleteMedicalTestById(int id);  //  IllegalArgumentException !!! Usunąć można encję po ID a nie samo ID

    @Delete
    int deleteMedicalTest(MedicalTest medicalTest);


}
