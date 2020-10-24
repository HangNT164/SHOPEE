package com.shopee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InformationShopActivity extends AppCompatActivity {
    private TextView backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_shop);
        backHome = findViewById(R.id.map);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(InformationShopActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}