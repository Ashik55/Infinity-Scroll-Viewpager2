package com.aashiq.infinitypager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private List<SliderItems> sliderItems;
    private ViewPager2 viewPager2;
    SliderAdapter(List<SliderItems> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }
    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container, parent, false
                ) );
    }
    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));

    }
    @Override
    public int getItemCount() {
        return sliderItems.size();
    }
    class SliderViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
        void setImage(SliderItems sliderItems){

            text.setText(sliderItems.getImage());

//use glide or picasso in case you get image from internet
//            imageView.setImageResource(sliderItems.getImage());
        }
    }



}