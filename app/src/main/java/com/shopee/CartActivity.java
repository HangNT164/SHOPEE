package com.shopee;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adapter.AddToCardAdapter;
import com.fragment.CardEmptyFragment;
import com.fragment.ListCardFragment;
import com.model.Brand;
import com.model.Card;
import com.util.ObjectSerializer;
import com.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.util.Helper.loadLocale;

public class CartActivity extends AppCompatActivity {
    private List<Card> cards;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.listCardProduct);
        cards = new ArrayList<>();
        // add fragment card
        CardEmptyFragment cardEmptyFragment = new CardEmptyFragment();
        ListCardFragment listCardFragment = new ListCardFragment();

        Product p = (Product) getIntent().getSerializableExtra("cart");
        Brand brand = (Brand) getIntent().getSerializableExtra("brand");
        String imageMain = getIntent().getStringExtra("imageMain");
        if (p != null) {
            // co san pham
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.layoutCard, listCardFragment, listCardFragment.getTag()).commit();
            // add phan tu card to list Cart
            Card card = new Card(p.getId(), p.getProductName(), imageMain, p.getSellPrice(), p.getOriginPrice(),
                    p.getColor(), 1, p.getQuantity(), p.getSellPrice() * p.getQuantity());
            cards.add(card);
            AddToCardAdapter addToCardAdapter = new AddToCardAdapter(getApplicationContext(), cards);
            recyclerView.setAdapter(addToCardAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // luu vao shared reference

            SharedPreferences prefs = getSharedPreferences("listCart", Context.MODE_PRIVATE);
            //save the user list to preference
            SharedPreferences.Editor editor = prefs.edit();
            try {
                editor.putString("UserList", ObjectSerializer.serialize((ArrayList) cards));
            } catch (IOException e) {
                e.printStackTrace();
            }
            editor.commit();

        } else {
            // check user have card or not : use shared references
            // empty
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.layoutCard, cardEmptyFragment, cardEmptyFragment.getTag()).commit();
        }


//        if(cards.size() <= 0){
//
//        }else{
//            transaction.replace(R.id.layoutCard,listCardFragment,listCardFragment.getTag()).commit();
//        }
        // when have card will replace by first is listCard fragment

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocale(getBaseContext(), "Language", "My_Lang");
    }
}