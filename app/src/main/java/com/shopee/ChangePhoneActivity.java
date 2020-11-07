package com.shopee;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dao.AccountDao;
import com.jdbc.RoomConnection;
import com.model.Account;
import com.model.AccountDetail;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.getSavedObjectFromPreference;

public class ChangePhoneActivity extends AppCompatActivity {
    private RoomConnection roomConnection;
    private AccountDao accountDao;
    private EditText txtInputPhone;
    private TextView saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone);
        final Account account = getSavedObjectFromPreference(getApplicationContext(), "accountPreference", "accountOfAccountDetail", Account.class);
        txtInputPhone = findViewById(R.id.txtPhoneNumber);
        saveData = findViewById(R.id.txtSaveDataPhone);

        txtInputPhone.setText(account.getMobile());

        roomConnection = getInstance(this);
        accountDao  = roomConnection.accountDao();

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMobile = txtInputPhone.getText().toString();
                account.setMobile(newMobile);
                accountDao.update(account);
                Toast.makeText(getApplicationContext(), "Update phone success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}