package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class PlacesDetails extends AppCompatActivity {

    DrawerLayout drawerLayout;
    FloatingActionButton floating_Location, floating_touristGuide;
    TextView title,description;
    SliderView sliderView;
    ArrayList<Integer>image;
    SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_details);

        //inflate
        drawerLayout          = findViewById(R.id.drawer_layout);
        floating_touristGuide = findViewById(R.id.floatingButton_TouristGuide);
        floating_Location     = findViewById(R.id.floatingButton_Location);
        sliderView            = findViewById(R.id.imageSlider_placesDetails);
        title                 = findViewById(R.id.places_details_title);
        description           = findViewById(R.id.places_details_describtion);


        //Go to TouristGuideList
        floating_touristGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TouristGuideList.class));
            }
        });




        image = new ArrayList<>();

        Intent i = getIntent();
        if(i.hasExtra("name")){
            switch (i.getStringExtra("name")){
                case "Nebu Mountain" :
                    title.setText(R.string.nebu_Title);
                    description.setText(R.string.nebu_Description);
                    image.add(R.drawable.nebo);
                    image.add(R.drawable.nebu2);
                    image.add(R.drawable.nebu3);
                    break;

                case "Amman Castle":
                    title.setText(R.string.amman_Castel_Title);
                    description.setText(R.string.amman_Castle_Description);
                    image.add(R.drawable.castel1);
                    image.add(R.drawable.amman_castle);
                    image.add(R.drawable.castel2);
                    break;

                case "Roman Amphitheater":
                    title.setText(R.string.roman_Title);
                    description.setText(R.string.roman_Description);
                    image.add(R.drawable.roman_1);
                    image.add(R.drawable.roman_2);
                    image.add(R.drawable.roman_3);
                    break;

                case "Dar Al Saraya Museum":
                    title.setText(R.string.museum_Title);
                    description.setText(R.string.museum_Description);
                    image.add(R.drawable.museam_1);
                    image.add(R.drawable.museam_2);
                    image.add(R.drawable.museam_3);
                    image.add(R.drawable.museam_4);
                    break;

                case "Arar Cultural House":
                    title.setText(R.string.arar_Title);
                    description.setText(R.string.arar_Description);
                    image.add(R.drawable.arar_1);
                    image.add(R.drawable.arar_2);
                    image.add(R.drawable.arar_3);
                    break;

                case "Dibeen Forest Reserve":
                    title.setText(R.string.dibben_Title);
                    description.setText((R.string.dibben_Description));
                    image.add(R.drawable.dibben_1);
                    image.add(R.drawable.dibben_2);
                    image.add(R.drawable.dibben_3);
                    image.add(R.drawable.dibben_4);
                    break;

                case "Hadrian's Arch":
                    title.setText(R.string.arch_Title);
                    description.setText(R.string.arch_Description);
                    image.add(R.drawable.arch_1);
                    image.add(R.drawable.arch_27);
                    image.add(R.drawable.arch_3);
                    image.add(R.drawable.arch);
                    break;

                case "Temple of Artemis":
                    title.setText(R.string.artemis_Title);
                    description.setText(R.string.artemis_Description);
                    image.add(R.drawable.artmies_1);
                    image.add(R.drawable.artmies_2);
                    image.add(R.drawable.artmies_3);
                    image.add(R.drawable.artmies_4);
                    break;
                case "Symposium Square":
                    title.setText(R.string.square_Title);
                    description.setText(R.string.square_Description);
                    image.add(R.drawable.square_1);
                    image.add(R.drawable.square_2);
                    image.add(R.drawable.square);
                    break;
                case "Horse Field":
                    title.setText(R.string.hourse_Title);
                    description.setText(R.string.hourse_Description);
                    image.add(R.drawable.hourse_2);
                    image.add(R.drawable.hourse);
                    image.add(R.drawable.hourse_1);
                    break;
                case "Columns Street":
                    title.setText(R.string.street_Title);
                    description.setText(R.string.street_Description);
                    image.add(R.drawable.street_1);
                    image.add(R.drawable.street_2);
                    image.add(R.drawable.street_3);
                    image.add(R.drawable.street_4);
                    break;

                case "Jerash South Theater":
                    title.setText(R.string.south_Title);
                    description.setText(R.string.south_Description);
                    image.add(R.drawable.south);
                    image.add(R.drawable.south_1);
                    image.add(R.drawable.south_2);
                    break;

                case "Jerash North Theatre":
                    title.setText(R.string.nourth_Title);
                    description.setText(R.string.nourth_Description);
                    image.add(R.drawable.nourth_1);
                    image.add(R.drawable.nourth_2);
                    image.add(R.drawable.nourth);
                    image.add(R.drawable.nourth_3);
                    break;

                case "Barqash Forests":
                    title.setText(R.string.barqash_Title);
                    description.setText(R.string.barqash_Description);
                    image.add(R.drawable.barqash);
                    image.add(R.drawable.barqash_1);
                    image.add(R.drawable.barqash_2);
                    image.add(R.drawable.barqash_3);
                    break;

                case "Ajloun Castle":
                    title.setText(R.string.ajloun_Title);
                    description.setText(R.string.ajloun_Description);
                    image.add(R.drawable.ajloan_castel_1);
                    image.add(R.drawable.ajloan_castel);
                    image.add(R.drawable.ajloan_castel_3);
                    image.add(R.drawable.ajloan_castel_2);
                    break;

                case "Ajloun Forest Reserve":
                    title.setText(R.string.ajloun_Fourest_Title);
                    description.setText(R.string.ajloun_Fourest_Description);
                    image.add(R.drawable.ajloun_fourest);
                    image.add(R.drawable.ajloun_fourest_1);
                    image.add(R.drawable.ajloun_fourest_2);
                    image.add(R.drawable.ajloun_fourest_3);
                    break;

                case "Silaa Castle":
                    title.setText(R.string.selaa_Title);
                    description.setText(R.string.selaa_Description);
                    image.add(R.drawable.selaa_1);
                    image.add(R.drawable.selaa_2);
                    image.add(R.drawable.selaa);
                    break;

                case "Aqaba Castle":
                    title.setText(R.string.aqaba_Castel_Title);
                    description.setText(R.string.aqaba_Castle_Description);
                    image.add(R.drawable.aqaba_castel_1);
                    image.add(R.drawable.aqaba_castel);
                    image.add(R.drawable.aqaba_castel_3);
                    image.add(R.drawable.aqaba_castel_2);
                    break;

                case "Ayla Oasis":
                    title.setText(R.string.ayla_Title);
                    description.setText(R.string.ayla_Description);
                    image.add(R.drawable.ayla_1);
                    image.add(R.drawable.ayla_2);
                    image.add(R.drawable.ayla_3);
                    image.add(R.drawable.ayla);
                    break;

                case "South Beach":
                    title.setText(R.string.beach_Title);
                    description.setText(R.string.beach_Description);
                    image.add(R.drawable.beach_2);
                    image.add(R.drawable.beach);
                    image.add(R.drawable.beach_4);
                    image.add(R.drawable.beach_3);
                    image.add(R.drawable.beach_1);
                    break;

                case "Petra":
                    title.setText(R.string.petra_Title);
                    description.setText(R.string.petra_Description);
                    image.add(R.drawable.petra_1);
                    image.add(R.drawable.petra_2);
                    image.add(R.drawable.petra_3);
                    image.add(R.drawable.petra_4);
                    image.add(R.drawable.petra);
                    break;

                case "Amra Palace":
                    title.setText(R.string.amra_Title);
                    description.setText(R.string.amra_Description);
                    image.add(R.drawable.amra_1);
                    image.add(R.drawable.amra_2);
                    image.add(R.drawable.amra_3);
                    image.add(R.drawable.amra);
                    break;
                case "Shaumari Reserve":
                    title.setText(R.string.reserve_Title);
                    description.setText(R.string.reserve_Description);
                    image.add(R.drawable.reserve_1);
                    image.add(R.drawable.reserve_2);
                    image.add(R.drawable.reserve);
                    break;

                case "Al Hallabat Palace":
                    title.setText(R.string.halabat_Title);
                    description.setText(R.string.halabat_Description);
                    image.add(R.drawable.alhalabat_1);
                    image.add(R.drawable.alhalabat_2);
                    image.add(R.drawable.alhalabat_3);
                    image.add(R.drawable.alhalabat);
                    break;

                case "Ma'in Bathrooms":
                    title.setText(R.string.main_Title);
                    description.setText(R.string.main_Description);
                    image.add(R.drawable.main_1);
                    image.add(R.drawable.main_2);
                    image.add(R.drawable.main_3);
                    break;
                case "Wadi Mujib":
                    title.setText(R.string.wadi_Title);
                    description.setText(R.string.wadi_Description);
                    image.add(R.drawable.wadi_4);
                    image.add(R.drawable.wadi);
                    image.add(R.drawable.wadi_3);
                    image.add(R.drawable.wadi_2);
                    image.add(R.drawable.wadi_1);
                    break;

                case "Wadi Rum":
                    title.setText(R.string.wadi_Title);
                    description.setText(R.string.rum_Description);
                    image.add(R.drawable.wadi_rum_1);
                    image.add(R.drawable.wadi_rum_5);
                    image.add(R.drawable.wadi_rum_4);
                    image.add(R.drawable.wadi_rum_3);
                    image.add(R.drawable.wadi_rum_2);
                    image.add(R.drawable.wadi_rum);
                    image.add(R.drawable.wadi_rum_6);
                    break;

                case "Karak Castle":
                    title.setText(R.string.karak_Title);
                    description.setText(R.string.karak_Description);
                    image.add(R.drawable.karak_castel_1);
                    image.add(R.drawable.karak_castel_2);
                    image.add(R.drawable.karak_castel_3);
                    image.add(R.drawable.karak_castel);
                    break;

            }
        }

        sliderAdapter = new SliderAdapter(image);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

       // Go to location (GoogleMap_L) Activity
        floating_Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),GoogleMap_L.class);
                i.putExtra("name",title.getText());
                startActivity(i);


            }
        });
    }


    //Back Activity
    public void ClickBack(View view){
        onBackPressed();
    }


    //NavigationDrawer
    public void ClickMenu(View view){
        NavigationDrawer.openDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        NavigationDrawer.redirectActivity(this,MainActivity.class);
    }

    public void ClickProfile(View view){
        NavigationDrawer.redirectActivity(this,UserProfile.class);
    }

    public void ClickLogout(View view){
        NavigationDrawer.Logout(PlacesDetails.this);
    }

    public  void ClickWeather(View view){
        startActivity(new Intent(PlacesDetails.this,Weather.class));
    }

    public void ClickLogo(View view){
        NavigationDrawer.closeDrawer(drawerLayout);
    }
}