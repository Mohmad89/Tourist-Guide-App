package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ImageView ivTop,ivHealth,ivBeat,ivBootom;
    TextView textView;
    CharSequence charSequence;
    int index;
    long delay = 200;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        //inflate
        ivTop    = findViewById(R.id.iv_top);
        ivHealth = findViewById(R.id.iv_heart);
        ivBeat   = findViewById(R.id.iv_beat);
        ivBootom = findViewById(R.id.iv_bottom);
        textView = findViewById(R.id.text_view);



        //set full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //initialize top animation
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.top_wave);
        //start top animation
        ivTop.setAnimation(animation1);

        //initialize object animator
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(ivHealth,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f));
        //set duration
        objectAnimator.setDuration(500);
        //set repeat count
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //set repeat mode
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        //Start animator
        objectAnimator.start();

        //Set animate text
        animatText("WELCOME");

        //Load GIF
        //       Glide.with(this).load()
        //Initialize botoom animation
        Animation animatioin2 = AnimationUtils.loadAnimation(this,R.anim.bottom_wave);

        //start bottom animation
        ivBootom.setAnimation(animatioin2);
        //Initialize handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Redirect to main activity
                startActivity(new Intent(SplashActivity.this,Login_Activity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                //Finish Activity
                finish();


            }
        },4000);



    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //Where runnable id run
            //Set text
            textView.setText(charSequence.subSequence(0,index++));
            //Check condition
            if(index <= charSequence.length()){
                //When index is equal to text length
                //Run handler
                handler.postDelayed(runnable,delay);
            }
        }
    };

    //Create animatad text method
    public void animatText(CharSequence cs){
        //Set text
        charSequence = cs;
        //Clear index
        index = 0;
        //Clear text
        textView.setText("");
        //Remove call back
        handler.removeCallbacks(runnable);
        //Run Handler
        handler.postDelayed(runnable,delay);
    }
}