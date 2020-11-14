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

import static com.util.Helper.formatNumber;

public class ListProductsAdapter extends RecyclerView.Adapter<ListProductsAdapter.MyViewHolder> {
    private Context context;
    private List<Product> listProduct;
    private List<Image> listImage;


    public ListProductsAdapter(Context context, List<Product> listProduct, List<Image> listImage) {
        this.context = context;
        this.listProduct = listProduct;
        this.listImage = listImage;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productPrice;
        ImageView imageView;
        MaterialCardView materialCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            imageView = itemView.findViewById(R.id.imageViewProduct);
            materialCardView = itemView.findViewById(R.id.itemProductLayout);
        }
    }

    @NonNull
    @Override
    public ListProductsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.get_all_product_layout, parent, false);
        return new ListProductsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductsAdapter.MyViewHolder holder, final int position) {
        holder.productName.setText(listProduct.get(position).getProductName());
        int price = (int) listProduct.get(position).getSellPrice();
        holder.productPrice.setText(formatNumber(price));
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
    }

    @Override
    public int getItemCount() {
//        if (listProduct.size() > 0) {
//            return listProduct.size();
//        }
//        return 0;
        return listProduct.size();
    }

}
