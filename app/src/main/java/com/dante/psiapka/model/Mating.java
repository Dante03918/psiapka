package com.dante.psiapka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "mating", foreignKeys = {@ForeignKey(entity = Heat.class, parentColumns = "id", childColumns = "heat_id"),
                                             @ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "father_id")})
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
}
