package com.dante.psiapka.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;

@Entity(tableName = "heat", foreignKeys = {@ForeignKey(entity = Dog.class, parentColumns = "id", childColumns = "dogId", onDelete = CASCADE)})
public class Heat {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dogId")
    public int dogId;

    @ColumnInfo(name = "heat_start_date")
    public Date heatStartDate;

    public Heat(int id, int dogId, Date heatStartDate) {
        this.id = id;
        this.dogId = dogId;
        this.heatStartDate = heatStartDate;
    }
    @Ignore
    public Heat(int dogId, Date heatStartDate) {
        this.dogId = dogId;
        this.heatStartDate = heatStartDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heat)) return false;
        Heat heat = (Heat) o;
        return dogId == heat.dogId && Objects.equals(heatStartDate, heat.heatStartDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogId, heatStartDate);
    }
}
