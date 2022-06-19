package com.dante.psiapka;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
//import com.dante.nexttraineeapp.databinding.ActivityMainBinding;

import com.dante.psiapka.dataManipulation.BreedDataManipulation;
import com.dante.psiapka.fragments.AddBreedLayoutFragment;
import com.dante.psiapka.fragments.BreedListFragment;
import com.dante.psiapka.interfaces.PassDataBetweenAddBreedLayoutFragmentAndMainActivity;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.templates.BreedTemplate;
import com.dante.psiapka.utils.ConvertIntentToBitmap;
import com.dante.psiapka.utils.SaveImageToInternalStorage;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements PassDataBetweenAddBreedLayoutFragmentAndMainActivity {

    private String permission;
    private int requestCodeForCheckPermission;
    private FragmentManager fragmentManager;

    private final BreedDataManipulation breedDataManipulation = new BreedDataManipulation();
    private Context context;
    private List<RelativeLayout> listFilledWithBreeds;
    private final BreedTemplate breedTemplate = new BreedTemplate();
    private LinearLayout layout;
    private BreedListFragment breedListFragment = null;

    public MainActivity(String permission, int requestCodeForCheckPermission) {
        this.permission = permission;
        this.requestCodeForCheckPermission = requestCodeForCheckPermission;
    }

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();
        breedDataManipulation.initDbInstance(context);
        setContentView(R.layout.container);
        fragmentManager = getSupportFragmentManager();

        try {
            breedListFragment = new BreedListFragment(breedTemplate.setBreedList(breedDataManipulation.getBreedsFromDb().get(), context));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.containerFrame, breedListFragment, null)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showAddBreedLayoutFragment(String data) {
        if (data.equals("switch")) {
            fragmentManager.beginTransaction()
                    .replace(R.id.containerFrame, AddBreedLayoutFragment.class, null)
                    .addToBackStack("add")
                    .commit();
        }
    }

    @Override
    public void addBreedToDB(Breed breed, @Nullable Intent imageData) {

        if (imageData == null) {
            breedDataManipulation.insertBreedToDatabase(new Breed(breed.getName(), breed.getThumbnailUrl()));
        } else {
            ConvertIntentToBitmap imageBitmap = new ConvertIntentToBitmap();
            ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
            SaveImageToInternalStorage saveImageToInternalStorage = new SaveImageToInternalStorage();
            String absolutePath = saveImageToInternalStorage.save(contextWrapper, "breedImages", imageBitmap.convert(imageData, this.getContentResolver()));
            breedDataManipulation.insertBreedToDatabase(new Breed(breed.getName(), absolutePath));
        }
        replaceFragmentWithBreedList();

    }

    @Override
    public void replaceFragmentWithBreedList() {
        try {
            fragmentManager.beginTransaction()
                    .replace(R.id.containerFrame, new BreedListFragment(breedTemplate.setBreedList(breedDataManipulation.getBreedsFromDb().get(), context)), null)
                    .addToBackStack(null)
                    .commit();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

