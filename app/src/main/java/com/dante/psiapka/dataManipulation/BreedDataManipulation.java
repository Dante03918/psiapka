package com.dante.psiapka.dataManipulation;

import android.content.Context;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Breed;

import java.util.ArrayList;
import java.util.List;

public class BreedDataManipulation {

    private Database databaseInstance;

    public void initDbInstance(Context context){
       Database.dbWriteExecutor.execute( () -> databaseInstance = Database.getInstance(context));
   }


    public void insertBreedToDatabase(Breed breed) {
        Database.dbWriteExecutor.execute(() -> {
            databaseInstance.breedDao().insertBreed(breed);
        });
    }

    public List<Breed> getBreedsFromDb() {

        List<Breed> allBreeds = new ArrayList<>();

        Database.dbWriteExecutor.execute(() -> allBreeds.addAll(databaseInstance.breedDao().getBreeds()));
        return allBreeds;
    }

}
