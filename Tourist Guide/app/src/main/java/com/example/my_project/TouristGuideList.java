package com.example.my_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TouristGuideList extends AppCompatActivity {
   DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    DatabaseReference reference;
    TouristGuideListAdapter adapter;
    ArrayList<UserHelperClass> list;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_guide_list);

        //inflate
        drawerLayout = findViewById(R.id.drawer_layout);
        progressBar  = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerViewTourist);
        reference    = FirebaseDatabase.getInstance().getReference("TourGuide");

        progressBar.setVisibility(View.VISIBLE);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new TouristGuideListAdapter(this,list);
        recyclerView.setAdapter(adapter);


        //Retrieve Data From Realtime Database in Firebase
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    UserHelperClass user = dataSnapshot.getValue(UserHelperClass.class);
                    list.add(user);
                }
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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
        startActivity(new Intent(TouristGuideList.this,Weather.class));
    }

    public void ClickLogout(View view){
        NavigationDrawer.Logout(TouristGuideList.this);
    }

}