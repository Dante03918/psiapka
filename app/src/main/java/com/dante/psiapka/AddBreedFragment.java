package com.dante.psiapka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddBreedFragment extends Fragment {
    public AddBreedFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.main_fragment_from_activity, container, false);


        return inflatedView;
    }

    //    ImageView imageView;
//    Uri imageUriToSend;
//    EditText breedEditText;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main_fragment_from_activity);

//        imageView = findViewById(R.id.add_breed_image_view);
//        Button openFileChooserBtn = findViewById(R.id.addBreedOpenFileChooser);
//        Button applyBtn = findViewById(R.id.addBreedApply);
//        breedEditText = findViewById(R.id.breedEditText);
//        openFileChooserBtn.setOnClickListener(view -> {
//
//            Intent fileChooser = new Intent(Intent.ACTION_GET_CONTENT);
//            fileChooser.setType("*/*");
//            startActivityForResult(fileChooser, 1);
//        });
//
//
//        applyBtn.setOnClickListener(this::sendDataToMainActivity);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//        if (resultCode == RESULT_OK) {
//            Uri imageUri = data.getData();
//            imageView.setImageURI(imageUri);
//            imageUriToSend = imageUri;
//        }
//
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    public void sendDataToMainActivity(View view){
//
//        Intent intent = new Intent(AddBreedActivity.this, MainActivity.class);
//        intent.putExtra("BREED",breedEditText.getText().toString() );
//        intent.putExtra("IAMGE_URI", imageUriToSend);
//
//        startActivity(intent);
//    }
//
//    //    public void openFileChooser(View view){
////        Intent fileChooser = new Intent(Intent.ACTION_GET_CONTENT);
////        fileChooser.setType("*image/*");
////        startActivity(fileChooser);
////    }

