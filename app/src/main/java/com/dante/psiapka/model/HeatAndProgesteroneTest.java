package com.dante.psiapka.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class HeatAndProgesteroneTest {
    @Embedded
    public Heat heat;

    @Relation(
            parentColumn = "id",
            entityColumn = "heat_id"
    )
    public List<ProgesteroneTest> progesteroneTests;
}
