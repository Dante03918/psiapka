package com.dante.psiapka.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;

@Entity(tableName = "mating", foreignKeys = {@ForeignKey(entity = Heat.class, parentColumns = "id", childColumns = "heat_id", onDelete = CASCADE),
                                             @ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "father_id", onDelete = CASCADE)})
public class Mating {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "heat_id")
    public int heatId;

    @ColumnInfo(name = "mating_date")
    public Date matingDate;

    @ColumnInfo(name = "father_id")
    public int fatherDogId;

    @ColumnInfo(name = "father_dog_name")
    public String name;

    public Mating(int id, int heatId, Date matingDate, int fatherDogId, String name) {
        this.id = id;
        this.heatId = heatId;
        this.matingDate = matingDate;
        this.fatherDogId = fatherDogId;
        this.name = name;
    }
    @Ignore
    public Mating(int heatId, Date matingDate, int fatherDogId, String name) {
        this.heatId = heatId;
        this.matingDate = matingDate;
        this.fatherDogId = fatherDogId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mating)) return false;
        Mating mating = (Mating) o;
        return heatId == mating.heatId && fatherDogId == mating.fatherDogId && Objects.equals(matingDate, mating.matingDate) && Objects.equals(name, mating.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heatId, matingDate, fatherDogId, name);
    }
}
