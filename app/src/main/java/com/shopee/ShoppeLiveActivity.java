package com.shopee;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class ShoppeLiveActivity extends AppCompatActivity {
    private CarouselView carouselView;
    private int[] lists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppe_live);
        // get data for list
        lists = new int[]{R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4, R.drawable.home5};
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(lists.length);

        // set data to carouse view
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.valueOf("CENTER_CROP"));
                imageView.setImageResource(lists[position]);
            }
        });
    }
}