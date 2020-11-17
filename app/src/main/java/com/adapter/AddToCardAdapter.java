package com.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.model.Card;
import com.shopee.CartActivity;
import com.shopee.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AddToCardAdapter extends RecyclerView.Adapter<AddToCardAdapter.ViewHolder> {
    private Context context;
    private List<Card> cards;

    public AddToCardAdapter(Context context, List<Card> cards) {
        this.context = context;
        this.cards = cards;
    }

    @NonNull
    @Override
    public AddToCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_card_product_layout, parent, false);
        return new AddToCardAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Card cart = cards.get(position);
        int quantity = cart.getQuantity();
        try {
            AssetManager assetManager = context.getAssets();
            InputStream ims = assetManager.open(cart.getImageLink());
            Drawable d = Drawable.createFromStream(ims, null);
            holder.imgView.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
        holder.name.setText(cart.getProductName());
        holder.price.setText(String.valueOf(cart.getSellPrice()));
        holder.quantity.setText(String.valueOf(cart.getQuantity()));
        holder.imgButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add
//                holder.quantity.setText(String.valueOf(Integer.valueOf(holder.quantity.getText().toString()) + 1));
//                saveCart(cards);
                Toast.makeText(context, "add", Toast.LENGTH_LONG).show();
            }
        });
        holder.imgButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sub
//                if (cart.getQuantity() > 0) {
//                    holder.quantity.setText(String.valueOf(Integer.valueOf(holder.quantity.getText().toString()) - 1));
                Toast.makeText(context, "sub", Toast.LENGTH_LONG).show();
//                } else {
//                    // remove
//                    cards.remove(position);
//                    Toast.makeText(context, "remove", Toast.LENGTH_LONG).show();
//                }
                saveCart(cards);
            }
        });
        holder.imgButtonRemoveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cards.remove(position);
                saveCart(cards);
                Intent intent = new Intent(context, CartActivity.class);
                context.startActivity(intent);
            }
        });
    }

    private void saveCart(List<Card> cardList) {
        SharedPreferences preferences = context.getSharedPreferences("Carts", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(cardList);
        editor.putString("listCart", json);
        editor.commit();
    }

    @Override
    public long getItemId(int position) {
        return cards.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price, quantity;
        public ImageView imgView;
        public ImageButton imgButtonSub, imgButtonAdd, imgButtonRemoveCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.productNameCard);
            price = itemView.findViewById(R.id.productPriceCard);
            quantity = itemView.findViewById(R.id.numberProductCard);
            imgView = itemView.findViewById(R.id.imageProductCard);
            imgButtonSub = itemView.findViewById(R.id.subNumberProduct);
            imgButtonAdd = itemView.findViewById(R.id.addNumberProduct);
            imgButtonRemoveCard = itemView.findViewById(R.id.removeProduct);
        }
    }
}
