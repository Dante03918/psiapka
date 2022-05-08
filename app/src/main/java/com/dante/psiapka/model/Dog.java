package com.dante.psiapka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "dog", foreignKeys = {@ForeignKey(entity = Breed.class, parentColumns = "id", childColumns = "breedId", onDelete = ForeignKey.CASCADE)})
public class Dog {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "breedId")   //foreign key from breed table
    int breedId;
    @ColumnInfo(name = "pedigreeName")
    String pedigreeName;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "gender")
    Enum<Gender> gender;
    @ColumnInfo(name = "dateOfBirth")
    Date dateOfBirth;
    @ColumnInfo(name = "chipNumber")
    int chipNumber;
    @ColumnInfo(name = "titles")
    String titles;
    @ColumnInfo(name = "rabiesVaccDate")
    Date rabiesVaccDate;
    @ColumnInfo(name = "virusVaccDate")
    Date virusVaccDate;
    @ColumnInfo(name = "allergies")
    String allergies;
    @ColumnInfo(name = "thumbnailUrl")
    String thumbnailUrl;
    @ColumnInfo(name = "pedigreeUrl")
    String pedigreeUrl;
    @ColumnInfo(name = "fatherId")   //foreign key from breed table
    String fatherId;
    @ColumnInfo(name = "fatherName")
    String fatherName;
    @ColumnInfo(name = "motherId")   //foreign key from breed table
    String motherId;
    @ColumnInfo(name = "motherName")
    String motherName;
    @ColumnInfo(name = "notes")
    String notes;

}
