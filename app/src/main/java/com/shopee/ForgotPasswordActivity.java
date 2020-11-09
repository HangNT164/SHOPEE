package com.shopee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.util.Helper.loadLocale;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText txtPhone;
    private Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_forgot_password);
        txtPhone = findViewById(R.id.txtSendPhone);
        btnSend = findViewById(R.id.sendCodeBtn);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = txtPhone.getText().toString().trim();

                if (mobile.isEmpty() || mobile.length() < 10) {
                    txtPhone.setError("Enter a valid mobile");
                    txtPhone.requestFocus();
                    return;
                }

                Intent intent = new Intent(ForgotPasswordActivity.this, ConfirmOTPActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadLocale(getBaseContext(), "Language", "My_Lang");
    }
}
