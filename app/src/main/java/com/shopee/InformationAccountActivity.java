package com.shopee;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adapter.DefaultAccountAdapter;
import com.dao.AccountDao;
import com.dao.ImageAvatarDao;
import com.jdbc.RoomConnection;
import com.model.AccountDetail;
import com.model.ImageAvatar;

import java.util.List;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.getSavedObjectFromPreference;

public class InformationAccountActivity extends AppCompatActivity {
    private RecyclerView settingAccount;
    private int imageSetting[];
    private String settingAccountString[];
    private TextView username;
    private ImageView imageAvatar;
    private RoomConnection roomConnection;
    private AccountDao accountDao;
    private ImageAvatarDao imageAvatarDao;
    private List<ImageAvatar> listsAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_account);
        AccountDetail accountDetail = getSavedObjectFromPreference(getApplicationContext(), "mPreference", "account", AccountDetail.class);
        settingAccount = findViewById(R.id.settingAccount);

        imageSetting = new int[]{R.drawable.heart, R.drawable.settings, R.drawable.help, R.drawable.introduce, R.drawable.language, R.drawable.logout};
        settingAccountString = getResources().getStringArray(R.array.inforInSettingAccount);
        DefaultAccountAdapter settingAccountAdapter = new DefaultAccountAdapter(this, settingAccountString, imageSetting);
        settingAccount.setAdapter(settingAccountAdapter);
        settingAccount.setLayoutManager(new LinearLayoutManager(this));

        username = findViewById(R.id.username);
        username.setText(accountDetail.getName());
        imageAvatar = findViewById(R.id.imageAvatar);
        roomConnection = getInstance(getApplicationContext());
        imageAvatarDao = roomConnection.imageAvatarDao();
        listsAvatar = imageAvatarDao.getImageAvatarByAccountDetail(accountDetail.getId());
        // check cover
//        String imageLink = listsAvatar.get(0).getImageLink();
    }
}