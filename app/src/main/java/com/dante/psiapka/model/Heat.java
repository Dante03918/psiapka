package com.dante.psiapka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "heat", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dog_id")})
public class Heat {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "dog_id")
    int dog_id;

    @ColumnInfo(name = "heat_start_date")
    Date heatStartDate;
}
