package com.shopee;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dao.AccountDao;
import com.dao.AccountDetailDao;
import com.jdbc.RoomConnection;
import com.model.Account;
import com.model.AccountDetail;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.saveObjectToSharedPreference;
import static com.util.ValidateData.isEmpty;

public class LoginActivity extends AppCompatActivity {
    private RoomConnection roomConnection;
    private AccountDao accountDao;
    private AccountDetailDao accountDetailDao;
    private EditText phone;
    private EditText password;
    private Button btnLogin;
    private TextView signInChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        roomConnection = getInstance(getApplicationContext());
        accountDao = roomConnection.accountDao();
        phone = findViewById(R.id.txtPhone);
        password = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.cirLoginButton);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check empty
                if (isEmpty(phone.getText().toString(), password.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please fill all input!", Toast.LENGTH_LONG).show();
                } else {
                    Account account = accountDao.login(phone.getText().toString(), password.getText().toString());
                    // ton tai account
                    if (account != null) {
                        accountDetailDao = roomConnection.accountDetailDao();
                        AccountDetail accountDetail = accountDetailDao.getOne(account.getAccountDetailID());
                        saveObjectToSharedPreference(getApplicationContext(), "mPreference", "account", accountDetail);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        signInChange = findViewById(R.id.signInChange);
        signInChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResgiterActivity.class);
                startActivity(intent);
            }
        });
    }
}