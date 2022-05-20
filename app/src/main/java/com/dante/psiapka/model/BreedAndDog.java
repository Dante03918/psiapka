package com.dante.psiapka.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BreedAndDog {
    @Embedded
    public Breed breed;
    @Relation(
            parentColumn = "id",
            entityColumn = "breedId"
    )
    public List<Dog> dogs;

}
