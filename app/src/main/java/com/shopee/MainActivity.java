package com.shopee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    private CarouselView carouselView;
    private int[] lists;
    private ImageView moreInfoNewProduct;
    private ImageView moreInfoHotProduct;
    private ImageView moreInfoAllProduct;
    private ImageView detailProduct;
    private ImageView categoryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        moreInfoAllProduct = findViewById(R.id.moreInfoAllProduct);
        moreInfoAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetAllProductActivity.class);
                startActivity(intent);
            }
        });

        moreInfoHotProduct = findViewById(R.id.moreInfoHotProduct);
        moreInfoHotProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HotProductActivity.class);
                startActivity(intent);
            }
        });

        moreInfoNewProduct = findViewById(R.id.moreInfoNewProduct);
        moreInfoNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewProductActivity.class);
                startActivity(intent);
            }
        });

        detailProduct = findViewById(R.id.detailProduct);
        detailProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailProductActivity.class);
                startActivity(intent);
            }
        });

        categoryImage = findViewById(R.id.category);
        categoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryProductActivity.class);
                startActivity(intent);
            }
        });
    }
}
