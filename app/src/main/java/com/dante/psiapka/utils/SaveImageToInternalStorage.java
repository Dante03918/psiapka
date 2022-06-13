package com.dante.psiapka.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class SaveImageToInternalStorage {

    public String save(ContextWrapper contextWrapper, String directoryName, Bitmap image){


        File imageDir = contextWrapper.getDir(directoryName, Context.MODE_PRIVATE);

        UUID randomFileName = UUID.randomUUID();

        File path = new File(imageDir, randomFileName.toString());

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(path);
            image.compress(Bitmap.CompressFormat.WEBP, 25, fileOutputStream);

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageDir.getAbsolutePath() + "/" + randomFileName;
    }
}
