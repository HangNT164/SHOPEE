package com.shopee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import static com.util.Helper.loadLocale;

public class GetAllProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_get_all_product);
    }
}