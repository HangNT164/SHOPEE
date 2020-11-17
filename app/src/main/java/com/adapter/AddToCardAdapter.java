package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.model.Card;
import com.shopee.R;
import com.util.Helper;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Card card = cards.get(position);
        holder.name.setText(card.getProductName());
        holder.price.setText(Helper.formatNumber((int) card.getSellPrice()));
        holder.quantity.setText(Integer.toString(card.getQuantity()));
        holder.imgButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card.getQuantity() > 1) {
                    card.setQuantity(card.getQuantity() - 1);
                }
            }
        });

        holder.imgButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card.getQuantity() < card.getProductQuantity()) {
                    card.setQuantity(card.getQuantity() + 1);
                }
            }
        });
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
        public ImageView imgView, imgSub, imgAdd;
        public ImageButton imgButtonSub, imgButtonAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.productNameCard);
            price = itemView.findViewById(R.id.productPriceCard);
            quantity = itemView.findViewById(R.id.numberProductCard);
            imgView = itemView.findViewById(R.id.imageProductCard);
            imgSub = itemView.findViewById(R.id.removeNumberProduct);
            imgAdd = itemView.findViewById(R.id.addNumberProduct);
            imgButtonSub = itemView.findViewById(R.id.removeNumberProduct);
            imgButtonSub = itemView.findViewById(R.id.addNumberProduct);
        }
    }
}
