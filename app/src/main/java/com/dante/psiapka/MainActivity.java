package com.dante.psiapka;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
//import com.dante.nexttraineeapp.databinding.ActivityMainBinding;

import com.dante.psiapka.configurations.Database;
import com.dante.psiapka.dataManipulation.BreedDataManipulation;
import com.dante.psiapka.databinding.ActivityMainBinding;
import com.dante.psiapka.fragments.AddBreedLayoutFragment;
import com.dante.psiapka.fragments.BreedListFragment;
import com.dante.psiapka.interfaces.PassDataBetweenAddBreedLayoutFragmentAndMainActivity;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.templates.BreedTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class MainActivity extends AppCompatActivity implements PassDataBetweenAddBreedLayoutFragmentAndMainActivity {

//    private ActivityMainBinding binding;

    private FragmentManager fragmentManager;

    BreedDataManipulation breedDataManipulation = new BreedDataManipulation();

    private Context context;

    List<RelativeLayout> listFilledWithBreeds;

    BreedTemplate breedTemplate = new BreedTemplate();

//    private List<BreedModel> breeds = new ArrayList<>();

    private LinearLayout layout;

//    Fragment addBreedFragment = new AddBreedFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getApplicationContext();

        breedDataManipulation.initDbInstance(context);

        setContentView(R.layout.container);

        fragmentManager = getSupportFragmentManager();

        final BreedListFragment breedListFragment = new BreedListFragment(breedTemplate.setBreedList(breedDataManipulation.getBreedsFromDb(), context));

        fragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.containerFrame, breedListFragment, null)
            .commit();




//        Toolbar toolbar = findViewById(R.id.toolbar);

        //getSupportActionBar().setIcon(getDrawable(R.drawable.ic___leading_icon_l_use_high_emphasis));
//        setSupportActionBar(toolbar);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());

//        Button button = findViewById(R.id.switchButton);
//
//        button.setBackground(this.getDrawable(R.drawable.back));

//        layout = findViewById(R.id.linearLayout);



//        button.setOnClickListener(view -> {

//            Intent fileChooser = new Intent(Intent.ACTION_GET_CONTENT);

//            fileChooser.setType("*image/*");
//
//            startActivityForResult(fileChooser, 1);
//            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//            startActivity(intent);

//                    RelativeLayout relativeLayout = new RelativeLayout(this);
//                    RelativeLayout tileRelativeLayout = new RelativeLayout(this);
//
//
//
//                    ImageView imageView = new ImageView(this);
//                    imageView.setId(View.generateViewId());
//                    imageView.setBackground(getDrawable(R.drawable.ic_launcher_background));
//
//                    ImageView tileBackground = new ImageView(this);
//
//                    tileBackground.setId(View.generateViewId());
//                    tileBackground.setBackground(getDrawable(R.color.black));
//                    tileBackground.setAlpha(0.35f);
//
//                    TextView tileText = new TextView(this);
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
//                    layout.addView(relativeLayout);
//                    Intent intent = new Intent(MainActivity.this, AddBreedFragment.class);
//                      intent.putExtra("BREED_LIST", breeds);
//                    startActivity(intent);


                }
//        );

//        retrieveDataFromAddBreedActivity(getIntent());

//        if (Storage.breeds.size() != 0) {
////            setBreedList();
//        }

    public void retrieveDataFromAddBreedActivity(Intent intent) {



        String breed = intent.getStringExtra("BREED");

        System.out.println("********" + breed + "*********");
        Uri uri = intent.getParcelableExtra("IAMGE_URI");

        System.out.println("********" + uri.toString() + "*********");

//        if (breed != null && uri != null) {
//            breedModel.setBreed(breed);
//            breedModel.setImageUri(uri);
//            Storage.breeds.add(breedModel);
//        }
    }

    @Override
    public void showAddBreedLayoutFragment(String data) {
        if (data.equals("switch")) {
            fragmentManager.beginTransaction()
                    .replace(R.id.containerFrame, AddBreedLayoutFragment.class, null)
                    .addToBackStack("add")
                    .commit();
        }
    }

    @Override
    public void addBreedToDB(Breed breed) {
        System.out.println(breed.getName());

        breedDataManipulation.insertBreedToDatabase(breed);

        breedDataManipulation.getBreedsFromDb();
    }
}




//
//
//        //Button button = (Button) binding.switchButton;
//
//
//        //   Intent intent = new Intent(this, SecondActivity.class);
////        startActivity(intent);
//
//
//    }

//    public void setBreedList() {
//        for (BreedModel model : Storage.breeds) {
//            RelativeLayout relativeLayout = new RelativeLayout(this);
//            RelativeLayout tileRelativeLayout = new RelativeLayout(this);
//
//            ImageView imageView = new ImageView(this);
//            imageView.setId(View.generateViewId());
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setImageURI(model.getImageUri());
//
//            ImageView tileBackground = new ImageView(this);
//
//            tileBackground.setId(View.generateViewId());
//            tileBackground.setBackground(getDrawable(R.color.black));
//            tileBackground.setAlpha(0.35f);
//
//            TextView tileText = new TextView(this);
//            tileText.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
//            tileText.setId(View.generateViewId());
//            tileText.setText(model.getBreed());
////                    tileText.setTextColor();
//
//
//            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            //params2.addRule(RelativeLayout.ALIGN_BASELINE,  tileBackground.getId());
//            tileRelativeLayout.addView(tileBackground, params2);
//
//            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params1.addRule(RelativeLayout.CENTER_IN_PARENT, tileBackground.getId());
//            tileRelativeLayout.addView(tileText, params1);
//
//
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(400, 400);
//            //params.addRule(RelativeLayout.ALIGN_BOTTOM,  imageView.getId());
//            relativeLayout.addView(imageView, params);
//
//            RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(400, 150);
//            params3.addRule(RelativeLayout.ALIGN_BOTTOM, imageView.getId());
//            relativeLayout.addView(tileRelativeLayout, params3);
//
//            relativeLayout.setPadding(0, 50, 0, 0);
//            relativeLayout.setHorizontalGravity(17);
//
//
////                    relativeLayout.addView(, params1);
//
//            // linear.
//
//
//            relativeLayout.setClickable(true);
//
//            relativeLayout.setOnClickListener(view -> System.out.println("Kliknieto w obrazek"));
//            layout.addView(relativeLayout);
//        }
//    }

