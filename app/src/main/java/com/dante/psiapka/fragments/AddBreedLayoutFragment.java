package com.dante.psiapka.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.dante.psiapka.databinding.AddBreedLayoutBinding;
import com.dante.psiapka.interfaces.PassDataBetweenAddBreedLayoutFragmentAndMainActivity;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.permissions.CheckPermission;

import java.io.File;
import java.io.IOException;

public class AddBreedLayoutFragment extends Fragment {

    PassDataBetweenAddBreedLayoutFragmentAndMainActivity passDataBetweenAddBreedLayoutFragmentAndMainActivity;
    AddBreedLayoutBinding addBreedLayoutBinding;

    ActivityResultLauncher<Intent> openFileChooserActivityResultLauncher;
    ActivityResultLauncher<Intent> cameraActivityResultLauncher;

    Uri uploadedImageUri;
    String breedName;
    Intent imageData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addBreedLayoutBinding = AddBreedLayoutBinding.inflate(inflater, container, false);

        passDataBetweenAddBreedLayoutFragmentAndMainActivity = (PassDataBetweenAddBreedLayoutFragmentAndMainActivity) getActivity();

        return addBreedLayoutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addBreedLayoutBinding.addBreedOpenFileChooser.setOnClickListener(this::getUrlFromFileChooser);

        openFileChooserActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        imageData = result.getData();
                        uploadedImageUri = imageData.getData();
                    }
                });
        cameraActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == Activity.RESULT_OK){
                    }
                }
        );

        addBreedLayoutBinding.openCamera.setOnClickListener((t) -> {
            CheckPermission checkPermission = new CheckPermission(Manifest.permission.CAMERA, 1, getActivity());
           if(checkPermission.checkPermission()){

               ContextWrapper contextWrapper = new ContextWrapper(getActivity());
               File pic = null;
               File imageDir = contextWrapper.getDir("breedImages", ContextWrapper.MODE_PRIVATE);
               try {
                    pic = File.createTempFile("camera", ".jpg", imageDir);
               } catch (IOException e) {
                   e.printStackTrace();                                                                             //TODO ogarnąć nadmiarowe pliki
               }

               Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               uploadedImageUri = FileProvider.getUriForFile(getActivity(), "com.dante.psiapka", pic);
               cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uploadedImageUri);
               cameraActivityResultLauncher.launch(cameraIntent);

           }
        });

        addBreedLayoutBinding.addBreedApply.setOnClickListener((t) -> {
            breedName = addBreedLayoutBinding.breedEditText.getText().toString();
            if (!breedName.equals("") && uploadedImageUri != null) {
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
        openFileChooserActivityResultLauncher.launch(intent);
    }

}
