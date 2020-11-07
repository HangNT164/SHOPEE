package com.shopee;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ChangeLanguageActivity extends AppCompatActivity {
    private RadioButton vietNameBtn;
    private RadioButton englishBtn;
    private TextView saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_change_language);
        vietNameBtn = findViewById(R.id.vietNameGroup);
        englishBtn = findViewById(R.id.englishGroup);
        saveBtn = findViewById(R.id.txtSaveData);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vietNameBtn.isChecked()) {
                    // tieng viet
                    setLocale("vi");
                } else {
                    // tieng anh
                    setLocale("en");
                }
                recreate();
                finish();
            }
        });
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        // save data to shared prences
        SharedPreferences.Editor editor = getSharedPreferences("Language", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Language", Activity.MODE_PRIVATE);
        String laguage = prefs.getString("My_Lang", "");
        setLocale(laguage);
    }
}