package com.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.model.Image;
import com.model.Product;
import com.shopee.DetailProductActivity;
import com.shopee.R;

import java.util.List;

public class ListProductTwoColumAdapter extends RecyclerView.Adapter<ListProductTwoColumAdapter.MyViewHolder> {
    private Context context;
    private List<Product> listProduct;
    private List<Product> listProductSecond;
    private List<Image> listImage;
    private List<Image> listImageSecond;


    public ListProductTwoColumAdapter(Context context, List<Product> listProduct, List<Product> listProductSecond, List<Image> listImage, List<Image> listImageSecond) {
        this.context = context;
        this.listProduct = listProduct;
        this.listProductSecond = listProductSecond;
        this.listImage = listImage;
        this.listImageSecond = listImageSecond;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productPrice;
        ImageView imageView;
        MaterialCardView materialCardView;
        TextView productNameSecond;
        TextView productPriceSecond;
        ImageView imageViewSecond;
        MaterialCardView materialCardViewSecond;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            imageView = itemView.findViewById(R.id.imageViewProduct);
            materialCardView = itemView.findViewById(R.id.itemProductLayout);

            productNameSecond = itemView.findViewById(R.id.productNameSecond);
            productPriceSecond = itemView.findViewById(R.id.productPriceSecond);
            imageViewSecond = itemView.findViewById(R.id.imageViewProductSecond);
            materialCardViewSecond = itemView.findViewById(R.id.itemProductLayoutSecond);
        }
    }

    @NonNull
    @Override
    public ListProductTwoColumAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_product_custom_two_row_layout, parent, false);
        return new ListProductTwoColumAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductTwoColumAdapter.MyViewHolder holder, final int position) {
        holder.productName.setText(listProduct.get(position).getProductName());
        holder.productPrice.setText(listProduct.get(position).getSellPrice() + "");
        //  holder.imageView.setImageResource(listImage.get(position).getImageLink());
        holder.materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailProductActivity.class);
                // intent.putExtra("image_url", listProduct.get(position).getProductName());
                Product product = listProduct.get(position);
                intent.putExtra("product", product);
                context.startActivity(intent);

            }
        });
        holder.productNameSecond.setText(listProductSecond.get(position).getProductName());
        holder.productPriceSecond.setText(listProductSecond.get(position).getSellPrice() + "");
        //  holder.imageView.setImageResource(listImage.get(position).getImageLink());
        holder.materialCardViewSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailProductActivity.class);
                // intent.putExtra("image_url", listProduct.get(position).getProductName());
                Product product = listProductSecond.get(position);
                intent.putExtra("product", product);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProductSecond.size();
    }

}
