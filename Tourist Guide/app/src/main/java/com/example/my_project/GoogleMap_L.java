package com.example.my_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMap_L extends FragmentActivity implements OnMapReadyCallback  {
    GoogleMap map;
    LatLng location;
    String place_Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        Intent i =getIntent();
        if(i.hasExtra("name")){
            switch (i.getStringExtra("name")){
                case "Roman Amphitheater":
                    location = new LatLng(31.951539, 35.939336);
                    place_Name = "Roman Amphitheater";

                    break;

                case "Amman Castle":
                    location = new LatLng(31.954286, 35.935422);
                    place_Name = "Amman Castle";
                    break;

                case "Nebu Mountain":
                    location = new LatLng(31.768329, 35.725255);
                    place_Name = "Nebu Mountain";
                    break;

                case "Dar Al Saraya Museum":
                    location = new LatLng(32.557775, 35.848016);
                    place_Name = "Dar Al Saraya Museum";
                    break;

                case "Arar Cultural House":
                    location = new LatLng(32.557540, 35.846694);
                    place_Name = "Arar Cultural House";
                    break;

                case "Dibeen Forest Reserve":
                    location = new LatLng(32.244328, 35.805714);
                    place_Name = "Dibeen Forest Reserve";
                    break;

                case "Hadrians Arch":
                    location = new LatLng(32.272340, 35.891239);
                    place_Name = "Hadrians Arch";
                    break;

                case "Temple of Artemis":
                    location = new LatLng(32.281748, 35.891053);
                    place_Name = "Temple of Artemis";
                    break;

                case "Symposium Square":
                    location = new LatLng(32.277564, 35.890791);
                    place_Name = "Stmposium Square";
                    break;

                case "Horse Field":
                    location = new LatLng(32.273103, 35.891109);
                    place_Name = "Horse Field";
                    break;

                case "Columns Street":
                    location = new LatLng(32.281150, 35.892709);
                    place_Name = "Columns Street";
                    break;

                case "Jerash South Theater":
                    location = new LatLng(32.276681, 35.889282);
                    place_Name = "Jerash South Theater";
                    break;

                case "Jerash North Theatre":
                    location = new LatLng(32.282581, 35.892529);
                    place_Name = "Jerash North Theater";
                    break;

                case "Barqash Forests":
                    location = new LatLng(32.443224, 35.739602);
                    place_Name = "Baraqash Forests";
                    break;

                case "Ajloun Castle":
                    location = new LatLng(32.325201, 35.727459);
                    place_Name = "Ajloun Castle";
                    break;

                case "Ajloun Forest Reserve":
                    location = new LatLng(32.380135, 35.763790);
                    place_Name = "Ajloun Forest Reserve";
                    break;

                case "Silaa Castle":
                    location = new LatLng(30.782073, 35.576374);
                    place_Name = "Silaa Castle";
                    break;

                case "Aqaba Castle":
                    location = new LatLng(29.521371, 35.001892);
                    place_Name = "Aqaba Castle";
                    break;

                case  "Ayla Oasis":
                    location = new LatLng(29.544754, 34.989664);
                    place_Name =  "Ayla Oasis";
                    break;

                case "South Beach":
                    location = new LatLng(29.496945, 34.990170);
                    place_Name = "South Beach";
                    break;

                case "Petra":
                    location = new LatLng(30.321628, 35.480106);
                    place_Name = "Petra";
                    break;

                case "Amra Palace":
                    location = new LatLng(31.801917, 36.587315);
                    place_Name = "Amra Palace";
                    break;

                case "Shaumari Reserve":
                    location = new LatLng(31.744806, 36.781755);
                    place_Name = "Shaumari Reserve";
                    break;

                case "Al Hallabat Palace":
                    location = new LatLng(32.077566, 36.370067);
                    place_Name = "Al Hallabat Palace";
                    break;

                case "Ma'in Bathrooms":
                    location = new LatLng(31.609350, 35.610522);
                    place_Name = "Ma'in Bathrooms";
                    break;

                case "Wadi Mujib":
                    location = new LatLng(31.407305, 35.889470);
                    place_Name = "Wadi Mujib";
                    break;

                case "Wadi Rum":
                    location = new LatLng(29.574294, 35.421043);
                    place_Name = "Wadi Rum";
                    break;

                case "Karak Castle":
                    location = new LatLng(31.180929, 35.701707);
                    place_Name = "Karak Castle";
                    break;
            }
        }

        map.addMarker(new MarkerOptions().position(location).title(place_Name));
        map.moveCamera(CameraUpdateFactory.newLatLng(location));




    }


}