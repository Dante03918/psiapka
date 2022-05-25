package com.dante.psiapka.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "thumbnail_file", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dog_id", onDelete = CASCADE)})
public class ThumbnailFile {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dog_id")
    public int dogId;

    @ColumnInfo(name = "url")
    public String fileNameUrl;

    public ThumbnailFile(int id, int dogId, String fileNameUrl) {
        this.id = id;
        this.dogId = dogId;
        this.fileNameUrl = fileNameUrl;
    }

    @Ignore
    public ThumbnailFile(int dogId, String fileNameUrl) {
        this.dogId = dogId;
        this.fileNameUrl = fileNameUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThumbnailFile)) return false;
        ThumbnailFile that = (ThumbnailFile) o;
        return dogId == that.dogId && Objects.equals(fileNameUrl, that.fileNameUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogId, fileNameUrl);
    }
}
