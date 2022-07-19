package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private RecyclerView mRecyclerView;
    private CitiesAdapter adapter;
    ArrayList<Cities> cities;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //inflate

        drawerLayout  = findViewById(R.id.drawer_layout);
        mRecyclerView = findViewById(R.id.recyclerView_mainActivity);

        adapter=new CitiesAdapter();
        cities = new ArrayList<>();



        //
        cities.add(new Cities("Petra",R.drawable.petra));
        cities.add(new Cities("Roman Amphitheater",R.drawable.roman_1));
        cities.add(new Cities("Amman Castle",R.drawable.castel1));
        cities.add(new Cities("Wadi Rum",R.drawable.wadi_rum));
        cities.add(new Cities("Nebu Mountain",R.drawable.nebo));
        cities.add(new Cities("Karak Castle",R.drawable.karak));
        cities.add(new Cities("Columns Street",R.drawable.street));
        cities.add(new Cities("Dibeen Forest Reserve",R.drawable.dibben));
        cities.add(new Cities("Jerash South Theater",R.drawable.south_2));
        cities.add(new Cities("Jerash North Theatre",R.drawable.nourth));
        cities.add(new Cities("Ajloun Castle",R.drawable.ajloan_castel));
        cities.add(new Cities("Barqash Forests",R.drawable.barqash_3));
        cities.add(new Cities("Hadrian's Arch",R.drawable.arch));
        cities.add(new Cities("Temple of Artemis",R.drawable.artmies));
        cities.add(new Cities("Ajloun Forest Reserve",R.drawable.ajloun_fourest_3));
        cities.add(new Cities("Aqaba Castle",R.drawable.aqapa));
        cities.add(new Cities("Ayla Oasis",R.drawable.ayla));
        cities.add(new Cities("Shaumari Reserve",R.drawable.reserve));
        cities.add(new Cities("Al Hallabat Palace",R.drawable.alhalabat));
        cities.add(new Cities("Amra Palace",R.drawable.amra));
        cities.add(new Cities("Ma'in Bathrooms",R.drawable.main));
        cities.add(new Cities("Wadi Mujib",R.drawable.wadi_3));
        cities.add(new Cities("South Beach",R.drawable.beach));
        cities.add(new Cities("Arar Cultural House",R.drawable.home));
        cities.add(new Cities("Dar Al Saraya Museum",R.drawable.museam));
        cities.add(new Cities("Symposium Square",R.drawable.square));
        cities.add(new Cities("Horse Field",R.drawable.hourse));
        cities.add(new Cities("Silaa Castle",R.drawable.selaa));




        adapter.setItems(cities);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);

        adapter.OnItemClickListner(new CitiesAdapter.OnClickListner() {
            @Override
            public void onClick(Cities category) {
                Intent i = new Intent(getApplicationContext(), PlacesDetails.class);
                i.putExtra("name",category.name);
                startActivity(i);
            }
        });








    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



    //Back Activity
    public void ClickBack(View view){
        onBackPressed();
    }

    //NavigationDrawer
    public void ClickHome(View view){
        NavigationDrawer.redirectActivity(this,MainActivity.class);
    }

    public void ClickProfile(View view){
        NavigationDrawer.redirectActivity(this,UserProfile.class);
    }

    public void ClickMenu(View view){
        NavigationDrawer.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view){

        NavigationDrawer.closeDrawer(drawerLayout);
    }

    public void ClickWeather(View view){
        startActivity(new Intent(MainActivity.this,Weather.class));
    }


    public void ClickLogout(View view){
        NavigationDrawer.Logout(MainActivity.this);
    }
}