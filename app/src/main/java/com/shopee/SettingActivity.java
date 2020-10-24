package com.shopee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SettingActivity extends AppCompatActivity {
    private ListView listViewTaiKhoanCuaToi, listViewHoTro, listViewcaiDat;
    private ArrayAdapter<String> adapterTaiKhoanCuaToi;
    private ArrayAdapter<String> adapterHoTro;
    private ArrayAdapter<String> adapterCaiDat;
    private String[] listStringTaiKhoanCuaToi;
    private String[] listStringHoTro;
    private String[] listStringCaiDat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        listStringTaiKhoanCuaToi = new String[]{"Hồ sơ của tôi", "Địa chỉ", "Tài khoản/Thẻ ngân hàng"};
        listStringHoTro = new String[]{"Huỷ tài khoản", "Điều khoản sử dụng", "Giới thiệu"};
        listStringCaiDat = new String[]{"Ngôn ngữ"};

        adapterTaiKhoanCuaToi = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, listStringTaiKhoanCuaToi);
        listViewTaiKhoanCuaToi = findViewById(R.id.taiKhoanCuaToi);
        listViewTaiKhoanCuaToi.setAdapter(adapterTaiKhoanCuaToi);

        adapterHoTro = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, listStringHoTro);
        listViewHoTro = findViewById(R.id.hoTro);
        listViewHoTro.setAdapter(adapterHoTro);

        adapterCaiDat = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, listStringCaiDat);
        listViewcaiDat = findViewById(R.id.caiDat);
        listViewcaiDat.setAdapter(adapterCaiDat);
    }
}