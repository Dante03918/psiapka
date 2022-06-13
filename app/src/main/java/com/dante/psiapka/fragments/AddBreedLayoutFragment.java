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
import androidx.appcompat.app.AlertDialog;
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
    Intent imageData;

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
                        imageData = result.getData();

                        uploadedImageUri = imageData.getData();

                    }
                });

        addBreedLayoutBinding.addBreedApply.setOnClickListener((t) -> {
            breedName = addBreedLayoutBinding.breedEditText.getText().toString();
            if(!breedName.equals("") && uploadedImageUri != null){
                sendDataToMainActivity(t);
            } else {
                AlertDialog.Builder msg = new AlertDialog.Builder(getActivity());
                msg.setMessage("Incomplete form");
                msg.setNegativeButton("Back to List", (dialog, i) -> passDataBetweenAddBreedLayoutFragmentAndMainActivity.replaceFragmentWithBreedList());
                msg.setPositiveButton("Fix", (dialog, i) -> dialog.cancel());
                msg.show();
            }
        });

    }

    private void sendDataToMainActivity(View view) {

        passDataBetweenAddBreedLayoutFragmentAndMainActivity.addBreedToDB(new Breed(breedName, uploadedImageUri.toString()), imageData);

    }

    public void getUrlFromFileChooser(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        activityResultLauncher.launch(intent);
    }

}
