package com.dante.psiapka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "thumbnailFile", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dogid")})
public class ThumbnailFile {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "dogid")
    int dogId;

    @ColumnInfo(name = "url")
    String fileNameUrl;

}
