package com.shopee;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import static com.util.Helper.loadLocale;

public class CategoryProductActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_category_product);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocale(getBaseContext(), "Language", "My_Lang");
    }

}