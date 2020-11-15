package com.shopee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dao.AccountDao;
import com.dao.AccountDetailDao;
import com.dao.ImageAvatarDao;
import com.jdbc.RoomConnection;
import com.model.Account;
import com.model.AccountDetail;
import com.model.ImageAvatar;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.loadLocale;
import static com.util.Helper.saveObjectToSharedPreference;
import static com.util.ValidateData.isEmpty;

public class LoginActivity extends AppCompatActivity {
    private RoomConnection roomConnection;
    private AccountDao accountDao;
    private ImageAvatarDao imageAvatarDao;
    private AccountDetailDao accountDetailDao;
    private EditText phone;
    private EditText password;
    private Button btnLogin;
    private TextView signInChange;
    private TextView forgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_login);
        roomConnection = getInstance(getApplicationContext());
        accountDao = roomConnection.accountDao();
        imageAvatarDao = roomConnection.imageAvatarDao();
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

                        // get image
                        ImageAvatar imageAvatar = imageAvatarDao.getOneByAccountDetail(accountDetail.getId());
                        ImageAvatar imageBia = imageAvatarDao.getOneByAccountDetailCoverFalse(accountDetail.getId());

                        // save image
                        saveObjectToSharedPreference(getApplicationContext(), "imageAvatar", "avatar", imageAvatar);
                        saveObjectToSharedPreference(getApplicationContext(), "imageBia", "bia", imageBia);

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
        forgotPass = findViewById(R.id.forgotPass);
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
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