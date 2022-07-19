package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TouristGuide extends AppCompatActivity {

    TextInputEditText firstName,lastName,phone,email;
    TextView upload;
    Button submitButton;
    RatingBar arabic,english;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_guide);

        //inflate
        firstName = findViewById(R.id.textInput_firstName);
        lastName  = findViewById(R.id.textInput_lastName);
        phone     = findViewById(R.id.textInput_phone);
        email     = findViewById(R.id.textInput_email);
        submitButton = findViewById(R.id.submit_button);
        upload    = findViewById(R.id.upload_text);
        arabic    = findViewById(R.id.ratingbar_arabic);
        english   = findViewById(R.id.ratingbar_English);




        //Save data in Firebase
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("TourGuide");

                double arabicPerc = arabic.getRating()*20;
                double englishPerc = english.getRating()*20;
                String firsname = firstName.getText().toString();
                String lastnaem = lastName.getText().toString();
                String phoneNu = phone.getText().toString();
                String emailAd = email.getText().toString();

                UserHelperClass user = new UserHelperClass(firsname,lastnaem,phoneNu,emailAd,arabicPerc,englishPerc);



                reference.child(phoneNu).setValue(user);
            }
        });

    }
}