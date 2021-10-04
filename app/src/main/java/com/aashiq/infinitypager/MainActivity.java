package com.aashiq.infinitypager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    //auto
    private Handler sliderHandler = new Handler();
    List<SliderItems> sliderItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager2 = findViewById(R.id.viewPagerImageSlider);


        sliderItems.add(new SliderItems("img 1"));
        sliderItems.add(new SliderItems("img 2"));
        sliderItems.add(new SliderItems("img 3"));



        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });


        viewPager2.setPageTransformer(compositePageTransformer);



        viewPager2.setCurrentItem(1);
        viewPager2.setVisibility(View.VISIBLE);



    }


}