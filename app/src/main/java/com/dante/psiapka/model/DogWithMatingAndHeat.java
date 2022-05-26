package com.dante.psiapka.model;


import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class DogWithMatingAndHeat {
    @Embedded
    public Dog dog;

    @Relation(
            parentColumn = "id",
            entityColumn = "father_id"
    )
    public List<Mating> matings;

    @Relation(
           parentColumn = "id",
            entityColumn = "dogId"
    )
    public List<Heat> heats;
}
