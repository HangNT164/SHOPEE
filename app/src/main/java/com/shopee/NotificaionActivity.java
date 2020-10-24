package com.shopee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.adapter.NotificationAdapter;

public class NotificaionActivity extends AppCompatActivity {

    private String listNotification[];
    private String detailNotification[];
    private int imagesNotification[];

    private RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaion);

        recyclerView = findViewById(R.id.notificationRecyclerView);

        imagesNotification = new int[]{R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4, R.drawable.home5, R.drawable.home4, R.drawable.home1};
        listNotification = getResources().getStringArray(R.array.notifications);
        detailNotification = getResources().getStringArray(R.array.detailNotifications);

        NotificationAdapter notificationAdapter = new NotificationAdapter(this, listNotification, detailNotification, imagesNotification);
        recyclerView.setAdapter(notificationAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}