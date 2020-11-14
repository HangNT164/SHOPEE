package com.shopee;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dao.BrandDao;
import com.google.android.material.textview.MaterialTextView;
import com.jdbc.RoomConnection;
import com.model.Brand;
import com.model.Product;

import static com.jdbc.RoomConnection.getInstance;
import static com.util.Helper.formatNumber;
import static com.util.Helper.loadLocale;

public class DetailProductActivity extends AppCompatActivity {

    private ImageView imageMainProduct;
    private ImageButton imageButtonFirst;
    private ImageButton imageButtonSecond;
    private ImageButton imageButtonThird;
    private TextView productName;
    private TextView productPrice;
    private TextView productDescription;
    private MaterialTextView colorProduct;
    private MaterialTextView brandProduct;
    private MaterialTextView quantityProduct;
    private MaterialTextView mauTemplate;
    private RoomConnection roomConnection;
    private Brand brand;
    private BrandDao brandDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_detail_product);
        getInstanceView();
        roomConnection = getInstance(getApplicationContext());
        brandDao = roomConnection.brandDao();
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Product product = (Product) getIntent().getSerializableExtra("product");
        if (product != null) {
            setProduct(product);
        }
    }


    private void setProduct(Product product) {
        brand = brandDao.getOneByProduct(product.getId());
        productName.setText(product.getProductName());
        productPrice.setText(formatNumber((int) product.getSellPrice()));
        productDescription.setText(product.getDescription());
        if (product.getColor() == null) {
            mauTemplate.setText("");
            colorProduct.setText("");
        } else {
            colorProduct.setText(product.getColor());
        }
        brandProduct.setText(brand.getBrandName());
        quantityProduct.setText(product.getQuantity() + "");
    }

    private void getInstanceView() {
        imageMainProduct = findViewById(R.id.imageViewProduct);
        imageButtonFirst = findViewById(R.id.imageProductFirst);
        imageButtonSecond = findViewById(R.id.imageProductSecond);
        imageButtonThird = findViewById(R.id.imageProductThird);
        productName = findViewById(R.id.detailProductName);
        productPrice = findViewById(R.id.productDetailPrice);
        productDescription = findViewById(R.id.productDetailDescription);
        colorProduct = findViewById(R.id.colorProduct);
        brandProduct = findViewById(R.id.brandProduct);
        mauTemplate = findViewById(R.id.mauTemplate);
        quantityProduct = findViewById(R.id.quantityProduct);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocale(getBaseContext(), "Language", "My_Lang");
        getIncomingIntent();
    }
}