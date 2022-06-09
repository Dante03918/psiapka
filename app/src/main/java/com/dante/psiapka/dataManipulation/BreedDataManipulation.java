package com.dante.psiapka.dataManipulation;

import android.content.Context;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Breed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

        Future<List<Breed>> result = Database.dbWriteExecutor.submit(() -> databaseInstance.breedDao().getBreeds());

        try {
            return result.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
