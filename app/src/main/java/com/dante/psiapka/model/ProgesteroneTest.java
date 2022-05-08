package com.dante.psiapka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "progesterone_test", foreignKeys = {@ForeignKey(entity = Heat.class, parentColumns = "id", childColumns = "heat_id")})
public class ProgesteroneTest {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "heat_id")
    int heatId;

    @ColumnInfo(name = "test_date")
    Date testDate;

    @ColumnInfo(name = "progesterone_level")
    double progesteroneLevel;
}
