package com.dante.psiapka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "photo", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dog_id")})
public class Photo {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "dog_id")
    int dogId;

    @ColumnInfo(name = "photo_url")
    String photoUrl;
}
