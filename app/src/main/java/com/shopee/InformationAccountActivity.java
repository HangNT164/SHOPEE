package com.shopee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.adapter.DefaultAccountAdapter;

public class InformationAccountActivity extends AppCompatActivity {
    private RecyclerView settingAccount;
    private int imageSetting[];
    private String settingAccountString[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_account);
        settingAccount = findViewById(R.id.settingAccount);

        imageSetting = new int[]{R.drawable.hangnguyen, R.drawable.hangnguyen, R.drawable.hangnguyen, R.drawable.hangnguyen};
        settingAccountString = new String[]{"Đã thích","Thiết lập tài khoản", "Trung tâm trợ giúp", "Giới thiệu"};

        DefaultAccountAdapter settingAccountAdapter = new DefaultAccountAdapter(this, settingAccountString, imageSetting);
        settingAccount.setAdapter(settingAccountAdapter);
        settingAccount.setLayoutManager(new LinearLayoutManager(this));
    }
}