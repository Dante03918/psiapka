package com.dante.psiapka.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "medical_test", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dog_id", onDelete = CASCADE)})
public class MedicalTest {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dog_id")
    public int dogId;

    @ColumnInfo(name = "test_url")
    public String testUrl;

    public MedicalTest(int id, int dogId, String testUrl) {
        this.id = id;
        this.dogId = dogId;
        this.testUrl = testUrl;
    }

    @Ignore
    public MedicalTest(int dogId, String testUrl) {
        this.dogId = dogId;
        this.testUrl = testUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalTest)) return false;
        MedicalTest that = (MedicalTest) o;
        return dogId == that.dogId && Objects.equals(testUrl, that.testUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogId, testUrl);
    }
}
