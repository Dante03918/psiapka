package com.dante.psiapka.model;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;
import java.util.Objects;

@Entity(tableName = "dog", foreignKeys = {@ForeignKey(entity = Breed.class, parentColumns = "id", childColumns = "breedId")})
public class Dog {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "breedId")   //foreign key from breed table
    public int breedId;
    @ColumnInfo(name = "pedigreeName")
    public String pedigreeName;
    @ColumnInfo(name = "name")
    public String name;
    @TypeConverters(com.dante.psiapka.utils.TypeConverters.class)
    @ColumnInfo(name = "gender")
    public Enum<Gender> gender;
    @ColumnInfo(name = "dateOfBirth")
    public Date dateOfBirth;
    @ColumnInfo(name = "chipNumber")
    public int chipNumber;
    @ColumnInfo(name = "titles")
    public String titles;
    @ColumnInfo(name = "rabiesVaccDate")
    public Date rabiesVaccDate;
    @ColumnInfo(name = "virusVaccDate")
    public Date virusVaccDate;
    @ColumnInfo(name = "allergies")
    public String allergies;
    @ColumnInfo(name = "thumbnailUrl")
    public String thumbnailUrl;
    @ColumnInfo(name = "pedigreeUrl")
    public String pedigreeUrl;
    @ColumnInfo(name = "fatherId")   //foreign key from breed table
    public String fatherId;
    @ColumnInfo(name = "fatherName")
    public String fatherName;
    @ColumnInfo(name = "motherId")   //foreign key from breed table
    public String motherId;
    @ColumnInfo(name = "motherName")
    public String motherName;
    @Nullable
    @ColumnInfo(name = "notes")
    public String notes;

    public Dog(int id,
               int breedId,
               String pedigreeName,
               String name,
               Enum<Gender> gender,
               Date dateOfBirth,
               int chipNumber,
               String titles,
               Date rabiesVaccDate,
               Date virusVaccDate,
               String allergies,
               String thumbnailUrl,
               String pedigreeUrl,
               String fatherId,
               String fatherName,
               String motherId,
               String motherName,
               @Nullable String notes) {
        this.id = id;
        this.breedId = breedId;
        this.pedigreeName = pedigreeName;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.chipNumber = chipNumber;
        this.titles = titles;
        this.rabiesVaccDate = rabiesVaccDate;
        this.virusVaccDate = virusVaccDate;
        this.allergies = allergies;
        this.thumbnailUrl = thumbnailUrl;
        this.pedigreeUrl = pedigreeUrl;
        this.fatherId = fatherId;
        this.fatherName = fatherName;
        this.motherId = motherId;
        this.motherName = motherName;
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return breedId == dog.breedId &&
                chipNumber == dog.chipNumber &&
                Objects.equals(pedigreeName, dog.pedigreeName) &&
                Objects.equals(name, dog.name) &&
                Objects.equals(gender, dog.gender) &&
                Objects.equals(dateOfBirth, dog.dateOfBirth) &&
                Objects.equals(titles, dog.titles) &&
                Objects.equals(rabiesVaccDate, dog.rabiesVaccDate) &&
                Objects.equals(virusVaccDate, dog.virusVaccDate) &&
                Objects.equals(allergies, dog.allergies) &&
                Objects.equals(thumbnailUrl, dog.thumbnailUrl) &&
                Objects.equals(pedigreeUrl, dog.pedigreeUrl) &&
                Objects.equals(fatherId, dog.fatherId) &&
                Objects.equals(fatherName, dog.fatherName) &&
                Objects.equals(motherId, dog.motherId) &&
                Objects.equals(motherName, dog.motherName) &&
                Objects.equals(notes, dog.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedId, pedigreeName, name, gender, dateOfBirth, chipNumber, titles, rabiesVaccDate, virusVaccDate, allergies, thumbnailUrl, pedigreeUrl, fatherId, fatherName, motherId, motherName, notes);
    }
}
