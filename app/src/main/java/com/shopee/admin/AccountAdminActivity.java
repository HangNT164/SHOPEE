package com.shopee.admin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.dao.AccountDao;
import com.dao.AccountDetailDao;
import com.dao.RoleDao;
import com.google.android.material.navigation.NavigationView;
import com.jdbc.RoomConnection;
import com.model.AccountDetail;
import com.model.Role;
import com.shopee.LoginActivity;
import com.shopee.R;

import java.util.ArrayList;
import java.util.List;

import ir.androidexception.datatable.DataTable;
import ir.androidexception.datatable.model.DataTableHeader;
import ir.androidexception.datatable.model.DataTableRow;

import static com.jdbc.RoomConnection.getInstance;

public class AccountAdminActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DataTable dataTable;
    private DataTableRow row;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView menuView;
    private RoomConnection roomConnection;
    private AccountDetailDao accountDetailDao;
    private AccountDao accountDao;
    private List<AccountDetail> listAccountDetail;
    private RoleDao roleDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_admin);
        dataTable = findViewById(R.id.data_table_account);

        roomConnection = getInstance(this);
        accountDetailDao = roomConnection.accountDetailDao();
        listAccountDetail = accountDetailDao.getAll();
        accountDao = roomConnection.accountDao();
        roleDao = roomConnection.roleDao();
        DataTableHeader header = new DataTableHeader.Builder()
                .item("No", 1)
                .item("Name", 3)
                .item("Address", 5)
                .item("Role", 3)
                .build();

        ArrayList<DataTableRow> rows = new ArrayList<>();

        for (int i = 0; i < listAccountDetail.size(); i++) {
            Role role = roleDao.getRoleByAccountDetial(listAccountDetail.get(i).getId());
            row = new DataTableRow.Builder()
                    .value(String.valueOf(i + 1))
                    .value(listAccountDetail.get(i).getName())
                    .value(listAccountDetail.get(i).getAddress())
                    .value(role.getRoleName())
                    .build();
            rows.add(row);
            TableRow row = (TableRow) dataTable.getChildAt(i);
            if (row != null) {
                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AccountAdminActivity.this, role.getRoleName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        dataTable.setHeader(header);
        dataTable.setRows(rows);
        dataTable.inflate(getApplicationContext());

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.drawer_layout);
        menuView = findViewById(R.id.iconMenu);

        menuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Intent intent = new Intent(this, DashboardAdminActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_product) {
            Intent intent = new Intent(this, ProductAdminActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_category) {
            Intent intent = new Intent(this, CategoryAdminActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_message) {
            Intent intent = new Intent(this, MessageAdminActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, SettingAdminActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_account) {
            Intent intent = new Intent(this, AccountAdminActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_order) {
            Intent intent = new Intent(this, OrderAdminActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            // remove shared references
            SharedPreferences sharedPreferences = getSharedPreferences("mPreferenceAdmin", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}