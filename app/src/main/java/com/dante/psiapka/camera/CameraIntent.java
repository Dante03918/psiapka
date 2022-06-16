package com.dante.psiapka.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import com.dante.psiapka.permissions.CheckPermission;

public class CameraIntent{

    private final Activity activity;
    private static final int CAMERA_REQUEST = 1;
    private static final int CAMERA = 2;
    private static final String CAMERA_PERMISSION = Manifest.permission.CAMERA;

    ActivityResultLauncher<Intent> activityResultLauncher;

    public CameraIntent(Activity activity) {
        this.activity = activity;
    }



    public Intent startCameraIntent() {

        final CheckPermission checkPermission = new CheckPermission(CAMERA_PERMISSION, CAMERA_REQUEST, activity);
        Intent camera;

        if (checkPermission.checkPermission()) {
            camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            activityResultLauncher.launch(camera);
        } else {
            camera = new Intent();
        }

        return camera;
    }
}
