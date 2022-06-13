package com.dante.psiapka.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dante.psiapka.MainActivity;
import com.dante.psiapka.R;
import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.dataManipulation.BreedDataManipulation;
import com.dante.psiapka.interfaces.PassDataBetweenAddBreedLayoutFragmentAndMainActivity;
import com.dante.psiapka.model.Breed;

import java.util.ArrayList;
import java.util.List;

public class BreedListFragment extends Fragment {

    PassDataBetweenAddBreedLayoutFragmentAndMainActivity passDataBetweenAddBreedLayoutFragmentAndMainActivity;
    BreedDataManipulation breedDataManipulation = new BreedDataManipulation();

    List<RelativeLayout> filledLayouts;
    LinearLayout rootLayout;


    public List<RelativeLayout> getFilledLayouts() {
        return filledLayouts;
    }

    public void setFilledLayouts(List<RelativeLayout> filledLayouts) {
        this.filledLayouts = filledLayouts;
    }

    public BreedListFragment(List<RelativeLayout> filledLayouts) {
        this.filledLayouts = filledLayouts;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.main_fragment_from_activity, container, false);


        passDataBetweenAddBreedLayoutFragmentAndMainActivity =(PassDataBetweenAddBreedLayoutFragmentAndMainActivity) getActivity();
        rootLayout = inflatedView.findViewById(R.id.linearLayout);

        for(RelativeLayout layout : filledLayouts){
            rootLayout.addView(layout);
            layout.setClickable(true);

            layout.setOnClickListener((view) -> {
                imageClicked(view);

            });
            layout.setOnLongClickListener(this::imageLongClicked);
        }

//        Button openFileChooserBtn = inflatedView.findViewById(R.id.addBreedOpenFileChooser);
//        Button applyBtn = inflatedView.findViewById(R.id.addBreedApply);
//        breedEditText = inflatedView.findViewById(R.id.breedEditText);
//        openFileChooserBtn.setOnClickListener(view -> {
//
//            Intent fileChooser = new Intent(Intent.ACTION_GET_CONTENT);
//            fileChooser.setType("*/*");
//
//        });





//        inflatedView.findViewById(R.id.addBreedButton).setOnClickListener(view -> {
//
//            Intent fileChooser = new Intent(Intent.ACTION_GET_CONTENT);
//
//            fileChooser.setType("*image/*");
//
//
//                    RelativeLayout relativeLayout = new RelativeLayout(getActivity());
//                    RelativeLayout tileRelativeLayout = new RelativeLayout(getActivity());
//
//
//
//                    ImageView imageView = new ImageView(getActivity());
//                    imageView.setId(View.generateViewId());
//                    imageView.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
//
//                    ImageView tileBackground = new ImageView(getActivity());
//
//                    tileBackground.setId(View.generateViewId());
//                    tileBackground.setBackground(getResources().getDrawable(R.color.black));
//                    tileBackground.setAlpha(0.35f);
//
//                    TextView tileText = new TextView(getActivity());
//                    tileText.setId(View.generateViewId());
//                    tileText.setText("Imie psa");
////                    tileText.setTextColor();
//
//
//
//                    RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                    //params2.addRule(RelativeLayout.ALIGN_BASELINE,  tileBackground.getId());
//                    tileRelativeLayout.addView(tileBackground, params2);
//
//                    RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    params1.addRule(RelativeLayout.CENTER_IN_PARENT,  tileBackground.getId());
//                    tileRelativeLayout.addView(tileText, params1);
//
//
//                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(400, 400);
//                    //params.addRule(RelativeLayout.ALIGN_BOTTOM,  imageView.getId());
//                    relativeLayout.addView(imageView, params);
//
//                    RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(400, 150);
//                    params3.addRule(RelativeLayout.ALIGN_BOTTOM,  imageView.getId());
//                    relativeLayout.addView(tileRelativeLayout, params3);
//
//                    relativeLayout.setPadding(0,20,0,0);
//                  relativeLayout.setHorizontalGravity(17);
//
//
//
////                    relativeLayout.addView(, params1);
//
//                   // linear.
//
//                    rootLayout.addView(relativeLayout);
////                    Intent intent = new Intent(getActivity(), AddBreedFragment.class);
////                      intent.putExtra("BREED_LIST", );
////                    startActivity(intent);
//
//
//                }


//        retrieveDataFromAddBreedActivity(getIntent());
        return inflatedView;
    }

        ImageView imageView;
    Uri imageUriToSend;
    EditText breedEditText;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Button addBreedButton = view.findViewById(R.id.addBreedButton);



        addBreedButton.setOnClickListener( (view1) -> {
            passDataBetweenAddBreedLayoutFragmentAndMainActivity.showAddBreedLayoutFragment("switch");
            rootLayout.removeAllViews();
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public void sendDataToMainActivity(View view){

        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra("BREED",breedEditText.getText().toString() );
        intent.putExtra("IAMGE_URI", imageUriToSend);                   //TODO Obsłużyć brak zdjęcia albo brak nazwy

        startActivity(intent);
    }

//    public void openFileChooser(View view){
//        Intent fileChooser = new Intent(Intent.ACTION_GET_CONTENT);
//        fileChooser.setType("*image/*");
//        startActivity(fileChooser);
//    }

    public void breedList(ArrayList<Breed> breeds){

    }

    public void imageClicked(View view){
        System.out.println("Przejście do szczegółów rasy");

    }
    public boolean imageLongClicked(View view){

        int breedId = ((RelativeLayout)view).getChildAt(0).getId();

        AlertDialog.Builder deleteConfirmation = new AlertDialog.Builder(getActivity());
        deleteConfirmation.setTitle("Delete confirmation");
        deleteConfirmation.setMessage("Do you really want to delete this item?");
        deleteConfirmation.setPositiveButton("Yes", (dialogInterface, i) -> {
            breedDataManipulation.initDbInstance(getActivity());

            breedDataManipulation.deleteById(breedId);
            passDataBetweenAddBreedLayoutFragmentAndMainActivity.replaceFragmentWithBreedList();
        });

        deleteConfirmation.show();



        return true;
    }
}
