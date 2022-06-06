package com.dante.psiapka.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dante.psiapka.databinding.AddBreedLayoutBinding;
import com.dante.psiapka.interfaces.PassDataBetweenAddBreedLayoutFragmentAndMainActivity;
import com.dante.psiapka.model.Breed;

public class AddBreedLayoutFragment extends Fragment {

    PassDataBetweenAddBreedLayoutFragmentAndMainActivity passDataBetweenAddBreedLayoutFragmentAndMainActivity;
    AddBreedLayoutBinding addBreedLayoutBinding;

    ActivityResultLauncher<Intent> activityResultLauncher;

    Uri uploadedImageUri;
    String breedName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addBreedLayoutBinding = AddBreedLayoutBinding.inflate(inflater, container,false);

        passDataBetweenAddBreedLayoutFragmentAndMainActivity = (PassDataBetweenAddBreedLayoutFragmentAndMainActivity) getActivity();

        return addBreedLayoutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addBreedLayoutBinding.addBreedOpenFileChooser.setOnClickListener(this::getUrlFromFileChooser);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        uploadedImageUri = data.getData();
                    }
                });

        addBreedLayoutBinding.addBreedApply.setOnClickListener(this::sendDataToMainActivity);

    }

    private void sendDataToMainActivity(View view) {

        breedName = addBreedLayoutBinding.breedEditText.getText().toString();
        passDataBetweenAddBreedLayoutFragmentAndMainActivity.addBreedToDB(new Breed(breedName, uploadedImageUri.toString()));

    }

    public void getUrlFromFileChooser(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        activityResultLauncher.launch(intent);
    }

}
