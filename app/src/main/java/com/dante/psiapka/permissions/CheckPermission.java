package com.dante.psiapka.permissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.dante.psiapka.R;

public class CheckPermission {

    private boolean ACCESS_GRANTED;

    private final String permission;
    private final int requestCodeForCheckPermission;
    private final Activity activity;

    public CheckPermission(String permission, int requestCodeForCheckPermission, Activity activity) {
        this.permission = permission;
        this.requestCodeForCheckPermission = requestCodeForCheckPermission;
        this.activity = activity;
    }

    public boolean checkPermission(){
        if(ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            String[] permissions = new String[]{permission};
            ActivityCompat.requestPermissions(activity, permissions, requestCodeForCheckPermission);

            if (ACCESS_GRANTED) {
                return true;
            } else {
                Toast.makeText(activity, R.string.permDenied, Toast.LENGTH_LONG).show();
                return false;
            }
        }
    }

    @SuppressLint("NewApi")
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        activity.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCodeForCheckPermission == requestCode){
            if(grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                ACCESS_GRANTED = true;
            } else {
                ACCESS_GRANTED = false;
            }
        }
    }
}
