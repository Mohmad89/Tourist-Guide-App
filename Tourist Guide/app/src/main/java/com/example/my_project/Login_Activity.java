package com.example.my_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login_Activity extends AppCompatActivity {
    EditText username,password;
    TextView sign_up,forgot;
    Button login;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    String Password_text;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    static String  Username_text;



    //Username_text getter and setter
    public static String getUsername_text() {
        return Username_text;
    }

    public static void setUsername_text(String username_text) {
        Username_text = username_text;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        //inflate
        username= findViewById(R.id.Login_edt_username);
        password= findViewById(R.id.Login_edt_password);
        sign_up = findViewById(R.id.Login_txt_signup);
        forgot  = findViewById(R.id.Login_txt_forget);
        login   = findViewById(R.id.Login_btn_login);
        progressBar = findViewById(R.id.Login_progressbar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference().child("Users");
        fAuth   = FirebaseAuth.getInstance();


        //Sign_in
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username_text = username.getText().toString();
                Password_text = password.getText().toString();

                if(TextUtils.isEmpty(Username_text)){
                    username.setError("Username Is Required.");
                    return;
                }

                if(TextUtils.isEmpty(Password_text)){
                    password.setError("Password Is Required.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Authentication the User


                    fAuth.signInWithEmailAndPassword(Username_text, Password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful() ) {
                                user = fAuth.getCurrentUser();
//                                if(user.isEmailVerified()) {
                                    Toast.makeText(Login_Activity.this, "Logged Successful.", Toast.LENGTH_SHORT).show();

                                    //**************************

                                    reference.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            for(DataSnapshot ds : snapshot.getChildren()){

                                                if(ds.child("email").getValue(String.class).equals(Username_text)){
                                                    Toast.makeText(Login_Activity.this, ""+ds.child("email").getValue(String.class)+"   "+ds.child("phone").getValue(String.class)+"  "+ds.child("userName").getValue(String.class), Toast.LENGTH_SHORT).show();
                                                    setUsername_text(Username_text);
                                                    break;

                                                }
                                            }

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                    //*************************




                                    startActivity(new Intent(getApplicationContext(), Second_activity.class));
                                    progressBar.setVisibility(View.VISIBLE);
                                    finish();

//                                }
//                                else {
//                                    Toast.makeText(Login_Activity.this, "your Email Dont Verify ! ", Toast.LENGTH_SHORT).show();
//                                    progBar.setVisibility(View.INVISIBLE);
//                                }

                            } else {
                                Toast.makeText(Login_Activity.this, "Logged Fail ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });




            }

        });

        progressBar.setVisibility(View.INVISIBLE);



        //**End Sign_in



;




        //**go to Sign_up Activity
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup_layout_intent =new  Intent(getBaseContext(),Sign_up_Activity.class);
                startActivity(signup_layout_intent);
            }
        });


        //**go to forgot Activity
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot_layout_intent=new Intent(getBaseContext(),Forgot_Activity.class);
                startActivity(forgot_layout_intent);
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = fAuth.getCurrentUser();
        if (user!=null && user.isEmailVerified()){
            startActivity(new Intent(Login_Activity.this,MainActivity.class));
            finish();
        }
    }
}