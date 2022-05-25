package com.dante.psiapka.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;

@Entity(tableName = "progesterone_test", foreignKeys = {@ForeignKey(entity = Heat.class, parentColumns = "id", childColumns = "heat_id", onDelete = CASCADE)})
public class ProgesteroneTest {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "heat_id")
    public int heatId;

    @ColumnInfo(name = "test_date")
    public Date testDate;

    @ColumnInfo(name = "progesterone_level")
    public double progesteroneLevel;

    public ProgesteroneTest(int id, int heatId, Date testDate, double progesteroneLevel) {
        this.id = id;
        this.heatId = heatId;
        this.testDate = testDate;
        this.progesteroneLevel = progesteroneLevel;
    }

    @Ignore
    public ProgesteroneTest(int heatId, Date testDate, double progesteroneLevel) {
        this.heatId = heatId;
        this.testDate = testDate;
        this.progesteroneLevel = progesteroneLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgesteroneTest)) return false;
        ProgesteroneTest that = (ProgesteroneTest) o;
        return heatId == that.heatId && Double.compare(that.progesteroneLevel, progesteroneLevel) == 0 && Objects.equals(testDate, that.testDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heatId, testDate, progesteroneLevel);
    }
}
