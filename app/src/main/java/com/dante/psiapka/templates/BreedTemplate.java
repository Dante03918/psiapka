package com.dante.psiapka.templates;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.dante.psiapka.R;
import com.dante.psiapka.model.Breed;

import java.util.ArrayList;
import java.util.List;


public class BreedTemplate {

    public List<RelativeLayout> setBreedList(List<Breed> breeds, Context context) {

        List<RelativeLayout> tiles = new ArrayList<>();

        for (Breed breed : breeds) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            RelativeLayout tileRelativeLayout = new RelativeLayout(context);

            ImageView imageView = new ImageView(context);
            imageView.setId(View.generateViewId());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

//            imageView.setImageBitmap(b);


            imageView.setImageURI(Uri.parse(breed.getThumbnailUrl()));
            imageView.setId(breed.getId());

//            Glide.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);
            System.out.println(imageView.getId());
//            imageView.setImageURI(Uri.parse(breed.getThumbnailUrl()));

            ImageView tileBackground = new ImageView(context);

            tileBackground.setId(View.generateViewId());
//            tileBackground.setBackground(getDrawable(R.color.black));
            tileBackground.setAlpha(0.35f);

            TextView tileText = new TextView(context);
            tileText.setTextColor(ContextCompat.getColor(context, R.color.white));
            tileText.setId(View.generateViewId());
            tileText.setText(breed.getName());
//                    tileText.setTextColor();


            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params2.addRule(RelativeLayout.ALIGN_BASELINE, tileBackground.getId());
            tileRelativeLayout.addView(tileBackground, params2);

            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params1.addRule(RelativeLayout.CENTER_IN_PARENT, tileBackground.getId());
            tileRelativeLayout.addView(tileText, params1);


            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(400, 400);
            params.addRule(RelativeLayout.ALIGN_BOTTOM, imageView.getId());
            relativeLayout.addView(imageView, params);

            RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(400, 150);
            params3.addRule(RelativeLayout.ALIGN_BOTTOM, imageView.getId());
            relativeLayout.addView(tileRelativeLayout, params3);

            relativeLayout.setPadding(0, 50, 0, 0);
            relativeLayout.setHorizontalGravity(17);


//                    relativeLayout.addView(, params1);

            // linear.


//            relativeLayout.setClickable(true);
//
//            relativeLayout.setOnClickListener(view -> System.out.println("Kliknieto w obrazek"));
//            relativeLayout.setOnLongClickListener(view -> {
//                System.out.println("Kliknięto długo");
//                return true;
//            });


            tiles.add(relativeLayout);

        }

        return tiles;
    }
}

