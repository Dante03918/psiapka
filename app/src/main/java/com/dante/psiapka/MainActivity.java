package com.dante.psiapka;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import com.dante.nexttraineeapp.databinding.ActivityMainBinding;
import androidx.fragment.app.Fragment;
import com.dante.psiapka.interfaces.PassDataBetweenFragmentAndActivity;

public class MainActivity extends AppCompatActivity implements PassDataBetweenFragmentAndActivity {

//    private ActivityMainBinding binding;


//    private List<BreedModel> breeds = new ArrayList<>();

    private LinearLayout layout;

    Fragment mainFragment = new MainFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);


    MainFragment mainFragment = new MainFragment(MainActivity.this);

    Bundle bundle = new Bundle();

    bundle.putString("CHOICE", "zmien");

    mainFragment.setArguments(bundle);

    getSupportFragmentManager().beginTransaction()
            .setReorderingAllowed(true)
//            .addSharedElement(findViewById(R.id.containerFrame), "CONTAINER12")
            .add(R.id.containerFrame, mainFragment, null)
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
//
////            Intent fileChooser = new Intent(Intent.ACTION_GET_CONTENT);
////
////            fileChooser.setType("*image/*");
////
////            startActivityForResult(fileChooser, 1);
////            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
////            startActivity(intent);
//
////                    RelativeLayout relativeLayout = new RelativeLayout(this);
////                    RelativeLayout tileRelativeLayout = new RelativeLayout(this);
////
////
////
////                    ImageView imageView = new ImageView(this);
////                    imageView.setId(View.generateViewId());
////                    imageView.setBackground(getDrawable(R.drawable.ic_launcher_background));
////
////                    ImageView tileBackground = new ImageView(this);
////
////                    tileBackground.setId(View.generateViewId());
////                    tileBackground.setBackground(getDrawable(R.color.black));
////                    tileBackground.setAlpha(0.35f);
////
////                    TextView tileText = new TextView(this);
////                    tileText.setId(View.generateViewId());
////                    tileText.setText("Imie psa");
//////                    tileText.setTextColor();
////
////
////
////                    RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
////                    //params2.addRule(RelativeLayout.ALIGN_BASELINE,  tileBackground.getId());
////                    tileRelativeLayout.addView(tileBackground, params2);
////
////                    RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
////                    params1.addRule(RelativeLayout.CENTER_IN_PARENT,  tileBackground.getId());
////                    tileRelativeLayout.addView(tileText, params1);
////
////
////                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(400, 400);
////                    //params.addRule(RelativeLayout.ALIGN_BOTTOM,  imageView.getId());
////                    relativeLayout.addView(imageView, params);
////
////                    RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(400, 150);
////                    params3.addRule(RelativeLayout.ALIGN_BOTTOM,  imageView.getId());
////                    relativeLayout.addView(tileRelativeLayout, params3);
////
////                    relativeLayout.setPadding(0,20,0,0);
////                  relativeLayout.setHorizontalGravity(17);
////
////
////
//////                    relativeLayout.addView(, params1);
////
////                   // linear.
////
////                    layout.addView(relativeLayout);
//                    Intent intent = new Intent(MainActivity.this, AddBreedActivity.class);
////                      intent.putExtra("BREED_LIST", breeds);
//                    startActivity(intent);
//
//
//                }
//        );

//        retrieveDataFromAddBreedActivity(getIntent());
//
//        if (Storage.breeds.size() != 0) {
////            setBreedList();
//        }

    }

    @Override
    public void dataRecived(String data) {
        if(data.equals("switch")){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrame, AddBreedFragment.class, null)
                    .addToBackStack("add")
                    .commit();
        }
    }

    //    public void retrieveDataFromAddBreedActivity(Intent intent) {
//
//        BreedModel breedModel = new BreedModel();
//
//        String breed = intent.getStringExtra("BREED");
//        Uri uri = intent.getParcelableExtra("IAMGE_URI");
//        if (breed != null && uri != null){
//            breedModel.setBreed(breed);
//            breedModel.setImageUri(uri);
//            Storage.breeds.add(breedModel);
//        }
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

}