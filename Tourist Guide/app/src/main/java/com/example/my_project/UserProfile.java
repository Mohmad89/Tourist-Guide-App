package com.example.my_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    TextView userName,email,phone,logout;
    DatabaseReference reference;
    FirebaseDatabase firebaseDatabase;
    DrawerLayout drawerLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);



        //inflate
        userName = findViewById(R.id.userName_profile);
        email    = findViewById(R.id.email_profile);
        phone    = findViewById(R.id.phone_profile);
        logout   = findViewById(R.id.logout_profile);
        drawerLayout = findViewById(R.id.drawer_layout);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference  = firebaseDatabase.getReference().child("Users");
//**************************

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){

                    if (ds.child("email").getValue(String.class).equals(Login_Activity.getUsername_text())) {

                        userName.setText(ds.child("userName").getValue(String.class));
                        email.setText(ds.child("email").getValue(String.class));
                        phone.setText(ds.child("phone").getValue(String.class));
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //*************************




        //logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfile.this);
                builder.setTitle("Logout");
                builder.setMessage("Are You Shure You Want To Logout ?");

                //positive Button
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        //finish avtivity
                        UserProfile.this.finishAffinity();
                        //Exit app
                        System.exit(0);
                    }
                });



                //Negative Button
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                //Show Dialog
                builder.show();
            }
        });

        //********


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
        startActivity(new Intent(UserProfile.this,Weather.class));
    }

    public void ClickLogout(View view){
        NavigationDrawer.Logout(UserProfile.this);
    }
}