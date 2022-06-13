package com.dante.psiapka.utils;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;

import java.io.IOException;

public class ConvertIntentToBitmap {

    public Bitmap convert(Intent image, ContentResolver resolver){

        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(resolver, image.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
