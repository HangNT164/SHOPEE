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
import com.jdbc.RoomConnection;
import com.model.Account;
import com.model.AccountDetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.isCheckUnique;
import static com.util.ValidateData.isEmpty;

public class ResgiterActivity extends AppCompatActivity {
    private EditText name;
    private EditText mobile;
    private EditText password;
    private EditText address;
    private EditText cfPassword;
    private Button btnSignIn;
    private TextView login;
    private RoomConnection roomConnection;
    private AccountDao accountDao;
    private AccountDetailDao accountDetailDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgiter);
        name = findViewById(R.id.editTextName);
        mobile = findViewById(R.id.editTextMobile);
        password = findViewById(R.id.editTextPassword);
        address = findViewById(R.id.editAddress);
        cfPassword = findViewById(R.id.editTextPasswordcf);
        btnSignIn = findViewById(R.id.cirLoginButton);
        roomConnection = getInstance(getApplicationContext());
        accountDao = roomConnection.accountDao();
        accountDetailDao = roomConnection.accountDetailDao();
        final String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check empty
                if (isEmpty(name.getText().toString(), mobile.getText().toString(), password.getText().toString(), address.getText().toString(), cfPassword.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please fill all input!", Toast.LENGTH_LONG).show();
                } else {
                    // check password = cf pass
                    // validate password
//                    if (isValidatePassword(password) == true) {
                    if (!password.getText().toString().equalsIgnoreCase(cfPassword.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password not match", Toast.LENGTH_LONG).show();
                    } else {
                        // check phone is unique
                        List<Account> lists = accountDao.getAll();
                        if (!isCheckUnique(lists, mobile.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Your phone is used!", Toast.LENGTH_LONG).show();
                        } else {
                            // add account detail
                            AccountDetail accountDetail = new AccountDetail(name.getText().toString(), address.getText().toString(), currentDate);
                            int accountDetailID = (int) accountDetailDao.add(accountDetail);
                            Account account = new Account(accountDetailID, 2, mobile.getText().toString(), password.getText().toString());
                            accountDao.add(account);
                            Toast.makeText(getApplicationContext(), "Register success!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ResgiterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Register Fail", Toast.LENGTH_SHORT).show();
//                    }
                }
            }
        });

        login = findViewById(R.id.loginChangePage);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResgiterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}