package com.example.my_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.login.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Second_activity extends AppCompatActivity {
    ImageView mTourImage, mGuideImage;
    DrawerLayout drawerLayout;

    FirebaseAuth fAuth;

    ImageView logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        //Inflate
        drawerLayout = findViewById(R.id.drawer_layout);
        mTourImage = findViewById(R.id.tourist_image);
        mGuideImage = findViewById(R.id.guide_image);
        logout = findViewById(R.id.toolbar_logout);



        //Go to MainActivity
        mTourImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        //Go to TouristGuide Activity
        mGuideImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TouristGuide.class));
            }
        });




        // logout page
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(getApplicationContext(),Login_Activity.class ));
//                finish();
//            }
//        });








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
    public void ClickWeather(View view){
        startActivity(new Intent(Second_activity.this,Weather.class));
    }

    public void ClickLogo(View view){

        NavigationDrawer.closeDrawer(drawerLayout);
    }

    public void ClickLogout(View view){
        NavigationDrawer.Logout(Second_activity.this);
    }








    //option menu

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.logout_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.menu_logout:
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(getApplicationContext(),Login_Activity.class ));
//                finish();
//                return true;
//
//        }
//        return false;
//    }


}