package com.example.my_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up_Activity extends AppCompatActivity {
    EditText fullName,password,email,phone;
    Button createBtn;
    TextView sign_In;
    FirebaseAuth fAuth;
    FirebaseUser user;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ProgressBar progressBar;
    String Email_text,Password_text,Name_text,Phone_text;
    UserDetails userDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);

        //inflate
        phone       = findViewById(R.id.Signup_edt_phone);
        fullName    = findViewById(R.id.Signup_edt_name);
        password    = findViewById(R.id.Signup_edt_password);
        email       = findViewById(R.id.Signup_edt_email);
        createBtn   = findViewById(R.id.Signup_button_create);
        sign_In     = findViewById(R.id.Signup_txt_signin);
        progressBar = findViewById(R.id.Signup_progressBar);



        fAuth = FirebaseAuth.getInstance();

        //Sign_up
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Email_text    = email.getText().toString();
                Password_text = password.getText().toString();
                Name_text     = fullName.getText().toString();
                Phone_text    =phone.getText().toString();


                if(TextUtils.isEmpty(Email_text)){
                    email.setError("Email Is Required. ");
                    return;
                }

                if(TextUtils.isEmpty(Password_text)){
                    password.setError("Password Is Required.");
                    return;
                }

                if(TextUtils.isEmpty(Name_text)){
                    fullName.setError("Name Is Required. ");
                    return;
                }
                if(TextUtils.isEmpty(Phone_text)){
                    phone.setError("Email Is Required. ");
                    return;
                }

                if(Password_text.length()<6){
                    password.setError("Password Must Be Grater Than 6 . ");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);

                //Register the User in Firebase


                fAuth.createUserWithEmailAndPassword(Email_text,Password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){


                            //Store Data On Firebase
                            rootNode  = FirebaseDatabase.getInstance();
                            reference = rootNode.getReference("Users");
                            userDetails = new UserDetails(Name_text, Email_text, Phone_text);
                            reference.child(Phone_text).setValue(userDetails);

                            Toast.makeText(Sign_up_Activity.this, "Account Created.", Toast.LENGTH_SHORT).show();



                            //Send Verification link
                            user=fAuth.getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {


                                    Toast.makeText(Sign_up_Activity.this,"Verification Email has been sent.",Toast.LENGTH_LONG).show();

                                    startActivity(new Intent(getApplicationContext(),Login_Activity.class));
                                    progressBar.setVisibility(View.VISIBLE);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(Sign_up_Activity.this, "Failure! "+e.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            });
                        }

                        else{

                            Toast.makeText(Sign_up_Activity.this, "Erorr!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }

                    }
                });


            }
        });


        //end Sign_up




        // I have already email
        sign_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login_Activity.class));
            }
        });



    }
}