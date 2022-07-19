package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Weather extends AppCompatActivity {

    Button btnSearch;
    EditText etCityName;
    ImageView img;
    TextView tvCity,tvTemp,minTemp,maxTemp,descriptions;
    ProgressBar progressBar;

    private static final String API_KEY="9fbf399d64f1d9eee0ec07446b12a2de";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weathers);

        btnSearch = findViewById(R.id.btnSearch);
        etCityName = findViewById(R.id.etCityName);
        img = findViewById(R.id.iconWeather);
        tvCity = findViewById(R.id.tvCity);
        tvTemp = findViewById(R.id.tvTemp);
        minTemp = findViewById(R.id.minTemp);
        maxTemp = findViewById(R.id.maxTemp);
        descriptions = findViewById(R.id.description);
        progressBar = findViewById(R.id.progress_bar);

        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String city = etCityName.getText().toString();
                if(city.isEmpty())
                    etCityName.setError("please Enter City Name");
                else {
                    //load weather by city name
                    loadWeatherByCityName(city);
                }



            }




        });

    }
    private void loadWeatherByCityName(String city) {
        Ion.with(this)
                .load("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+API_KEY)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error
                        if(e != null ){
                            e.printStackTrace();
                            Toast.makeText(Weather.this, "Server Error", Toast.LENGTH_SHORT).show();
                        }

                        else{
                            //convert jason response to java
                            JsonObject main = result.get("main").getAsJsonObject();
                            //temp
                            int temps = (int) main.get("temp").getAsDouble();
                            int temp = temps - 273 ;
                            tvTemp.setText(temp+" ْ°C");

                            //maxTemp
                            int maxtemps = (int) main.get("temp_max").getAsDouble();
                            int maxtemp = maxtemps - 273 ;
                            maxTemp.setText("Max Temp:  "+maxtemp+" ْ°C");

                            //minTemp
                            int mintemps = (int) main.get("temp_min").getAsDouble();
                            int mintemp = mintemps - 273 ;
                            minTemp.setText("Min Temp:  "+mintemp+" ْ°C");

                            JsonObject sys = result.get("sys").getAsJsonObject();
                            String country = sys.get("country").getAsString() ;
                            tvCity.setText(city+", "+country);

                            // but for brevity, use the ImageView specific builder...
                            JsonArray weather = result.get("weather").getAsJsonArray();
                            String icon = weather.get(0).getAsJsonObject().get("icon").getAsString();
                            loadIcon(icon);

                            String desc = weather.get(0).getAsJsonObject().get("description").getAsString();
                            descriptions.setText(desc);

                            progressBar.setVisibility(View.INVISIBLE);

                        }
                    }


                });

    }
    private void loadIcon(String icon) {
        Ion.with(this)
                .load("http://openweathermap.org/img/w/"+icon+".png")
                .intoImageView(img);
    }
}