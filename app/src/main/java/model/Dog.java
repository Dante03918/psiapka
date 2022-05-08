package model;

import android.net.Uri;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Arrays;

@Entity(tableName = "dog", foreignKeys = {@ForeignKey(entity = Breed.class, parentColumns = "id", childColumns = "breedId", onDelete = ForeignKey.CASCADE)})
public class Dog {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "breedId")   //foreign key from breed table
    int breedId;
}
