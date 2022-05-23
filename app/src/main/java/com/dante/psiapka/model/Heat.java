package com.dante.psiapka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "heat", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dog_id")})
public class Heat {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dog_id")
    public int dog_id;

    @ColumnInfo(name = "heat_start_date")
    public Date heatStartDate;

    public Heat(int id, int dog_id, Date heatStartDate) {
        this.id = id;
        this.dog_id = dog_id;
        this.heatStartDate = heatStartDate;
    }
    @Ignore
    public Heat(int dog_id, Date heatStartDate) {
        this.dog_id = dog_id;
        this.heatStartDate = heatStartDate;
    }
}
