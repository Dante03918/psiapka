package com.dante.psiapka;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
//import com.dante.nexttraineeapp.databinding.ActivityMainBinding;

import com.dante.psiapka.dataManipulation.BreedDataManipulation;
import com.dante.psiapka.fragments.AddBreedLayoutFragment;
import com.dante.psiapka.fragments.BreedListFragment;
import com.dante.psiapka.interfaces.PassDataBetweenAddBreedLayoutFragmentAndMainActivity;
import com.dante.psiapka.model.Breed;
import com.dante.psiapka.templates.BreedTemplate;
import com.dante.psiapka.utils.ConvertIntentToBitmap;
import com.dante.psiapka.utils.SaveImageToInternalStorage;

import java.util.List;
import java.util.concurrent.ExecutionException;



public class MainActivity extends AppCompatActivity implements PassDataBetweenAddBreedLayoutFragmentAndMainActivity {

    private String permission;
    private int requestCodeForCheckPermission;
    private FragmentManager fragmentManager;

    private final BreedDataManipulation breedDataManipulation = new BreedDataManipulation();
    private Context context;
    private List<RelativeLayout> listFilledWithBreeds;
    private final BreedTemplate breedTemplate = new BreedTemplate();
    private LinearLayout layout;
    private BreedListFragment breedListFragment = null;

    public MainActivity(String permission, int requestCodeForCheckPermission){
        this.permission = permission;
        this.requestCodeForCheckPermission = requestCodeForCheckPermission;
    }
    public MainActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = getApplicationContext();

        breedDataManipulation.initDbInstance(context);


        setContentView(R.layout.container);

        // breedDataManipulation.deleteAllFromBreedTable();
        fragmentManager = getSupportFragmentManager();


        try {
            breedListFragment = new BreedListFragment(breedTemplate.setBreedList(breedDataManipulation.getBreedsFromDb().get(), context));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.containerFrame, breedListFragment, null)
                .addToBackStack(null)
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
    public void addBreedToDB(Breed breed, Intent imageData) {

        ConvertIntentToBitmap imageBitmap = new ConvertIntentToBitmap();
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        SaveImageToInternalStorage saveImageToInternalStorage = new SaveImageToInternalStorage();

        String absolutePath = saveImageToInternalStorage.save(contextWrapper, "breedImages", imageBitmap.convert(imageData, this.getContentResolver()));

        breedDataManipulation.insertBreedToDatabase(new Breed(breed.getName(), absolutePath));

        replaceFragmentWithBreedList();

    }

    @Override
    public void replaceFragmentWithBreedList() {
        try {
            fragmentManager.beginTransaction()
                    .replace(R.id.containerFrame, new BreedListFragment(breedTemplate.setBreedList(breedDataManipulation.getBreedsFromDb().get(), context)), null)
                    .addToBackStack(null)
                    .commit();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
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

