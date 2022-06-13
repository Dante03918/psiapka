package com.dante.psiapka.dataManipulation;

import android.content.Context;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.model.Breed;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class BreedDataManipulation {

    private Database databaseInstance;

    public void initDbInstance(Context context){
       Database.dbWriteExecutor.execute( () -> databaseInstance = Database.getInstance(context));
   }

    public void insertBreedToDatabase(Breed breed) {

        Future insert  = Database.dbWriteExecutor.submit(() -> databaseInstance.breedDao().insertBreed(breed));

        try{
            insert.get();
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public Future<List<Breed>> getBreedsFromDb() {

        Future<List<Breed>> result = Database.dbWriteExecutor.submit(() -> databaseInstance.breedDao().getBreeds());

        return result;
    }

    public void deleteById (int id ){
        try {
            Database.dbWriteExecutor.submit(() -> databaseInstance.breedDao().deleteBreedById(id)).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllFromBreedTable(){
        Database.dbWriteExecutor.execute( () -> databaseInstance.breedDao().deleteAllBreeds());
    }
}
