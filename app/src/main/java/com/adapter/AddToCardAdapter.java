package com.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.model.Card;
import com.shopee.R;
import com.util.Helper;

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
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        final Card cart = cards.get(position);
//        double totalPrice = 0;
//        for (Card c: cards) {
//            totalPrice += c.getTotalPrice();
//        }
//        // set for main
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
        holder.quantity.setText(Integer.toString(cart.getQuantity()));
//        holder.totalPrice.setText(String.valueOf(totalPrice));
//        holder.imgButtonSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cart.getQuantity() > 1) {
//                    cart.setQuantity(cart.getQuantity() - 1);
//                    cart.setTotalPrice(cart.getQuantity() * cart.getSellPrice());
//                    saveCart((List<Card>) cart);
//
//                }
//            }
//        });
//
//        holder.imgButtonAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cart.getQuantity() < cart.getProductQuantity()) {
//                    cart.setQuantity(cart.getQuantity() + 1);
//                    cart.setTotalPrice(cart.getQuantity() * cart.getSellPrice());
//                    saveCart((List<Card>) cart);
//                }
//            }
//        });

//        holder.imgButtonRemoveCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cards.remove(position);
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, cards.size());
//            }
//        });
    }

    private void saveCart(List<Card> cardList){
        SharedPreferences preferences = context.getSharedPreferences("Carts",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(cardList);
        editor.putString("listCart",json);
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
        public TextView name, price, quantity,totalPrice;
        public ImageView imgView;
        public ImageButton imgButtonSub, imgButtonAdd, imgButtonRemoveCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.productNameCard);
            price = itemView.findViewById(R.id.productPriceCard);
            quantity = itemView.findViewById(R.id.numberProductCard);
            imgView = itemView.findViewById(R.id.imageProductCard);
            totalPrice = itemView.findViewById(R.id.txtTotalPriceCart);
            imgButtonSub = itemView.findViewById(R.id.removeNumberProduct);
            imgButtonAdd = itemView.findViewById(R.id.addNumberProduct);
            imgButtonRemoveCard = itemView.findViewById(R.id.removeProduct);
        }
    }
}
