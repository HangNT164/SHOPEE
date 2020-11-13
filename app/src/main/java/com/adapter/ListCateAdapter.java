package com.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.model.Category;
import com.model.ImageCategory;
import com.shopee.CategoryProductActivity;
import com.shopee.R;

import java.util.List;

public class ListCateAdapter extends RecyclerView.Adapter<ListCateAdapter.MyViewHolder> {
    private Context context;
    private List<Category> listCate;
    private List<ImageCategory> listImage;

    public ListCateAdapter(Context context, List<Category> listCate, List<ImageCategory> listImage) {
        this.context = context;
        this.listCate = listCate;
        this.listImage = listImage;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView imageView;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            imageView = itemView.findViewById(R.id.imageCate);
            linearLayout = itemView.findViewById(R.id.layoutCate);
        }
    }

    @NonNull
    @Override
    public ListCateAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_layout, parent, false);
        return new ListCateAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListCateAdapter.MyViewHolder holder, final int position) {
        holder.categoryName.setText(listCate.get(position).getCategoryName());
        //  holder.imageView.setImageResource(listImage.get(position).getImageLink());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category category = listCate.get(position);
                Intent intent = new Intent(context, CategoryProductActivity.class);
                intent.putExtra("category", category);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCate.size();
    }

}
