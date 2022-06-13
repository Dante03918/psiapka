package com.dante.psiapka.interfaces;

import android.content.Intent;

import com.dante.psiapka.model.Breed;

public interface PassDataBetweenAddBreedLayoutFragmentAndMainActivity {

    void showAddBreedLayoutFragment(String data);
    void addBreedToDB(Breed breed, Intent imageData);
    void replaceFragmentWithBreedList();

}
