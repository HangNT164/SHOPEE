

package com.shopee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adapter.ListProductsAdapter;
import com.dao.ImageDao;
import com.dao.ProductDao;
import com.jdbc.RoomConnection;
import com.model.Image;
import com.model.Product;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.loadLocale;

public class MainActivity extends AppCompatActivity {

    private CarouselView carouselView;
    private int[] lists;
    private ImageView moreInfoNewProduct;
    private ImageView moreInfoHotProduct;
    private ImageView moreInfoAllProduct;
    private ImageView categoryImage;
    private RoomConnection roomConnection;
    private ProductDao productDao;
    private ImageDao imageDao;
    private List<Product> listProductHot;
    private List<Product> listProductNew;
    private List<Product> listProduct;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewHot;
    private RecyclerView recyclerViewList;
    private List<Image> listImage;
    private LinearLayoutManager layoutManager;
    private LinearLayoutManager layoutManagerHot;
    private LinearLayoutManager layoutManagerNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_main);

        findInstanceInView();

        layoutManagerHot = new org.solovyev.android.views.llm.LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManagerNew = new org.solovyev.android.views.llm.LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager = new org.solovyev.android.views.llm.LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // get data for list
        lists = new int[]{R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4, R.drawable.home5};
        carouselView.setPageCount(lists.length);

        // set data to carouse view
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.valueOf("CENTER_CROP"));
                imageView.setImageResource(lists[position]);
            }
        });

        // More information of Get All Product
        moreInfoAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetAllProductActivity.class);
                startActivity(intent);
            }
        });

        // More information of Hot Product
        moreInfoHotProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HotProductActivity.class);
                startActivity(intent);
            }
        });

        // More information of Get New Product
        moreInfoNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewProductActivity.class);
                startActivity(intent);
            }
        });

        categoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryProductActivity.class);
                startActivity(intent);
            }
        });

        roomConnection = getInstance(getApplicationContext());
        productDao = roomConnection.productDao();
        imageDao = roomConnection.imageDao();
        listImage = imageDao.getAll();

        // New product
        listProductNew = productDao.getNewProductMain();
        loadDataForRecyclerView(recyclerView, listProductNew, layoutManagerNew, listImage);

        // Hot product
        listProductHot = productDao.getHotProductMain();
        loadDataForRecyclerView(recyclerViewHot, listProductHot, layoutManagerHot, listImage);

        // All Product
        listProduct = productDao.getAllMain();
        loadDataForRecyclerView(recyclerViewList, listProduct, layoutManager, listImage);

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocale(getBaseContext(), "Language", "My_Lang");
    }

    /**
     * Load all instance need in view
     */
    private void findInstanceInView() {
        recyclerView = findViewById(R.id.listNewProductMain);
        recyclerViewHot = findViewById(R.id.listHotProductMain);
        recyclerViewList = findViewById(R.id.listsProductMain);
        carouselView = findViewById(R.id.carouselView);
        moreInfoAllProduct = findViewById(R.id.moreInfoAllProduct);
        moreInfoHotProduct = findViewById(R.id.moreInfoHotProduct);
        moreInfoNewProduct = findViewById(R.id.moreInfoNewProduct);
        categoryImage = findViewById(R.id.category);
    }

    /**
     * Load data for recycler view
     *
     * @param recyclerView:  recycler view want to show
     * @param listProduct:         list product want to list
     * @param layoutManager: layout
     * @param listImages:    list image want to list
     */
    private void loadDataForRecyclerView(RecyclerView recyclerView, List<Product> listProduct, LinearLayoutManager layoutManager, List<Image> listImages) {
        if (listProduct.size() > 0) {
            ListProductsAdapter listProductAllAdapter = new ListProductsAdapter(this, listProduct, listImages);
            recyclerView.setAdapter(listProductAllAdapter);
            recyclerView.setLayoutManager(layoutManager);
        }
    }
}
