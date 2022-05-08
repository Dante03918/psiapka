package com.dante.psiapka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "medical_test", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dog_id")})
public class MedicalTest {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "dog_id")
    int dogId;

    @ColumnInfo(name = "test_url")
    String testUrl;
}
