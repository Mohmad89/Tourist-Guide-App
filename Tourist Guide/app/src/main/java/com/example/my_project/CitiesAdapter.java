package com.example.my_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    private List<Cities> mCategoriesList = new ArrayList<>();
    private OnClickListner mListner;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_for_main_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Cities currentItem = mCategoriesList.get(position);

        holder.name.setText(currentItem.name);
        holder.image.setImageResource(currentItem.photo);
    }

    public void setItems(List<Cities> categories) {
        mCategoriesList = categories;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mCategoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.card_view_main_text);
            image =itemView.findViewById(R.id.card_view_main_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    if (mListner != null && index != RecyclerView.NO_POSITION) {
                        mListner.onClick(mCategoriesList.get(index));


                    }
                }
            });
        }
    }

    //On item click :
    public interface OnClickListner {
        void onClick(Cities category);
    }

    public void OnItemClickListner(OnClickListner listner) {

        mListner = listner;

    }

    public Cities getCategoryAt(int pos) {
        return mCategoriesList.get(pos);
    }
}

