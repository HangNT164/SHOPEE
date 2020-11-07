package com.shopee;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static com.util.Helper.loadLocale;

public class ForgotPasswordActivity extends AppCompatActivity {
    private Button sendCodeBtn;
    private EditText txtSendPhone;
    private String phoneNo;
    private final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_forgot_password);
        sendCodeBtn = findViewById(R.id.sendCodeBtn);
        txtSendPhone = findViewById(R.id.txtSendPhone);
        sendCodeBtn.setEnabled(false);
        if (checkPermission(Manifest.permission.SEND_SMS)) {
            sendCodeBtn.setEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);
        }
        sendCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNo = txtSendPhone.getText().toString();
                if (phoneNo == null || phoneNo.length() == 0) {
                    return;
                }
                if (checkPermission(Manifest.permission.SEND_SMS)) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, "abc", null, null);
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkPermission(String permission) {
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}