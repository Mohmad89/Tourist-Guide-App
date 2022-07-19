package com.example.my_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {
              ArrayList<Integer> image;

    public SliderAdapter(ArrayList<Integer> image) {
        this.image = image;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_places_details,parent,false);

        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.image_item.setImageResource(image.get(position));

    }

    @Override
    public int getCount() {
        return image.size();
    }

    public class ViewHolder extends  SliderViewAdapter.ViewHolder{
              ImageView image_item;
       public ViewHolder(View itemView) {
           super(itemView);
           image_item = itemView.findViewById(R.id.slider_Item_Image);
;       }
   }
}
