package com.dante.psiapka.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "photo", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dog_id", onDelete = CASCADE)})
public class Photo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dog_id")
    public int dogId;

    @ColumnInfo(name = "photo_url")
    public String photoUrl;

    public Photo(int id, int dogId, String photoUrl) {
        this.id = id;
        this.dogId = dogId;
        this.photoUrl = photoUrl;
    }

    @Ignore
    public Photo(int dogId, String photoUrl) {
        this.dogId = dogId;
        this.photoUrl = photoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return dogId == photo.dogId && Objects.equals(photoUrl, photo.photoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogId, photoUrl);
    }
}
