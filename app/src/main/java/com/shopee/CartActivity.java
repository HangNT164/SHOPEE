package com.shopee;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.fragment.CardEmptyFragment;
import com.fragment.ListCardFragment;

import static com.util.Helper.loadLocale;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale(getBaseContext(), "Language", "My_Lang");
        setContentView(R.layout.activity_cart);

        // add fragment card
        CardEmptyFragment cardEmptyFragment = new CardEmptyFragment();
        ListCardFragment listCardFragment = new ListCardFragment();

        // check user have card or not : use shared references
        // empty
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.layoutCard, cardEmptyFragment, cardEmptyFragment.getTag()).commit();

        // when have card will replace by first is listCard fragment

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocale(getBaseContext(), "Language", "My_Lang");
    }
}