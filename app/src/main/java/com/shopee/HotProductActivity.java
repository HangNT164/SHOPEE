package com.shopee;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adapter.ListProductsAdapter;
import com.dao.ImageDao;
import com.dao.ProductDao;
import com.jdbc.RoomConnection;
import com.model.Image;
import com.model.Product;
import com.util.Helper;

import java.util.List;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.loadLocale;

public class HotProductActivity extends AppCompatActivity {
    private RoomConnection roomConnection;
    private ProductDao productDao;
    private ImageDao imageDao;
    private List<Product> listProduct;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewSecond;
    private List<Image> listImage;
    private List<Product> listEven;
    private List<Product> listOdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_hot_product);
        recyclerView = findViewById(R.id.listProduct);
        recyclerViewSecond = findViewById(R.id.listProductSecond);

        roomConnection = getInstance(getApplicationContext());
        productDao = roomConnection.productDao();

        listProduct = productDao.getHotProduct();
        imageDao = roomConnection.imageDao();
        listImage = imageDao.getAll();

        listEven = new Helper().getListProductByIndex(listProduct, 1);
        listOdd = new Helper().getListProductByIndex(listProduct, 2);

        ListProductsAdapter listProductsAdapter = new ListProductsAdapter(this, listOdd, listImage);
        recyclerView.setAdapter(listProductsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ListProductsAdapter listProductsAdapterSecond = new ListProductsAdapter(this, listEven, listImage);
        recyclerViewSecond.setAdapter(listProductsAdapterSecond);
        recyclerViewSecond.setLayoutManager(new LinearLayoutManager(this));

        // Close scoll of recyclerview
        recyclerView.setNestedScrollingEnabled(false);
        recyclerViewSecond.setNestedScrollingEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocale(getBaseContext(), "Language", "My_Lang");
    }
}