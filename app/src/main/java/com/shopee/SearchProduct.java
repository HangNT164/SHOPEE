package com.shopee;

import android.os.Bundle;
import android.widget.TextView;

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

public class SearchProduct extends AppCompatActivity {
    private RoomConnection roomConnection;
    private ProductDao productDao;
    private ImageDao imageDao;
    private List<Product> listProduct;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewSecond;
    private List<Image> listImage;
    private List<Product> listEven;
    private List<Product> listOdd;
    private TextView notFound;
    private TextView productOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        String searchName = getIntent().getStringExtra("productName");
        recyclerView = findViewById(R.id.listProduct);
        recyclerViewSecond = findViewById(R.id.listProductSecond);
        notFound = findViewById(R.id.notfound);
        productOther = findViewById(R.id.cacSanPham);

        roomConnection = getInstance(getApplicationContext());
        productDao = roomConnection.productDao();

        listProduct = productDao.searchProductByProductName(searchName);

        // Check list have product Name
        if (listProduct.size() > 0) {
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
        } else {
            notFound.setText("Not found product:  " + searchName);
            productOther.setText("Product other");
            listProduct = productDao.getAll();
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

    }
}