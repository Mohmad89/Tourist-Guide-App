package com.example.my_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TouristGuideListAdapter extends RecyclerView.Adapter<TouristGuideListAdapter.ViewHolder> {

    Context context;
    ArrayList<UserHelperClass> list;

    public TouristGuideListAdapter(Context context, ArrayList<UserHelperClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_tourist_guide,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserHelperClass user =list.get(position);
        double Ara = user.getArabicPerc();
        double Eng = user.getEnglishPerc();


        holder.firstName.setText(user.getFirstName()+" ");
        holder.phone.setText(user.getPhone());
        holder.email.setText(user.getEmail());

        if(Ara >= 90 )
            holder.arabic.setText("Excellent");

        else if(Ara >= 80 && Ara < 90)
            holder.arabic.setText("Very Good");

        else if(Ara >= 70 && Ara <80)
            holder.arabic.setText("Good");
        else
            holder.arabic.setText("LOW");

        if(Eng >= 90 )
            holder.english.setText("Excellent");

        else if(Eng >= 80 && Eng < 90)
            holder.english.setText("Very Good");

        else if(Eng >= 70 && Eng <80)
            holder.english.setText("Good");
        else
            holder.english.setText("LOW");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView firstName,email,phone,arabic,english;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.touristGuide_name);
            email = itemView.findViewById(R.id.email_touristGuide);
            phone = itemView.findViewById(R.id.phone_touristGuide);
            arabic = itemView.findViewById(R.id.text_arabicRating);
            english = itemView.findViewById(R.id.text_englishRating);
        }
    }
}
