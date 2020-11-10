package com.shopee;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.model.Product;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_detail_product);
        imageMainProduct = findViewById(R.id.imageViewProduct);
        imageButtonFirst = findViewById(R.id.imageProductFirst);
        imageButtonSecond = findViewById(R.id.imageProductSecond);
        imageButtonThird = findViewById(R.id.imageProductThird);
        productName = findViewById(R.id.detailProductName);
        productPrice = findViewById(R.id.productDetailPrice);
        productDescription = findViewById(R.id.productDetailDescription);
        colorProduct = findViewById(R.id.colorProduct);
        brandProduct = findViewById(R.id.brandProduct);
        quantityProduct = findViewById(R.id.quantityProduct);
        getIncomingIntent();
    }

     private void getIncomingIntent() {
        Product product = (Product) getIntent().getSerializableExtra("product");
        if (product != null) {
            setProduct(product);
        }
    }


    private void setProduct(Product product) {
        productName.setText(product.getProductName());
        productPrice.setText(String.valueOf(product.getSellPrice()));
        productDescription.setText(product.getDescription());
        colorProduct.setText(product.getColor());
        brandProduct.setText(product.getBrandID() + "");
        quantityProduct.setText(product.getQuantity() + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocale(getBaseContext(), "Language", "My_Lang");
    }
}