package com.dante.psiapka.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class DogAndThumbnailFile {
    @Embedded
    public Dog dog;
    @Relation(
            parentColumn = "id",
            entityColumn = "dog_id"
    )
    public List<ThumbnailFile> thumbnailFiles;
}
