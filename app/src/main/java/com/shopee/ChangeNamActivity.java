package com.shopee;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dao.AccountDetailDao;
import com.jdbc.RoomConnection;
import com.model.AccountDetail;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.getSavedObjectFromPreference;
import static com.util.Helper.saveObjectToSharedPreference;

public class ChangeNamActivity extends AppCompatActivity {
    private RoomConnection roomConnection;
    private AccountDetailDao accountDetailDao;
    private EditText txtInputName;
    private TextView saveData;
    private AccountDetail accountDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nam);
        accountDetail = getSavedObjectFromPreference(getApplicationContext(), "mPreference", "account", AccountDetail.class);
        txtInputName = findViewById(R.id.txtInputName);
        saveData = findViewById(R.id.txtSaveData);

        txtInputName.setText(accountDetail.getName());
        roomConnection = getInstance(this);
        accountDetailDao = roomConnection.accountDetailDao();

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = txtInputName.getText().toString();
                accountDetail.setName(newName);
                accountDetailDao.update(accountDetail);
                Toast.makeText(getApplicationContext(), "Update name success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}