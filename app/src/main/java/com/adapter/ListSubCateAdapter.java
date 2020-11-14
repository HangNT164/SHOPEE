package com.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.model.ImageSubCate;
import com.model.SubCategory;
import com.shopee.ListProductBySubCateActivity;
import com.shopee.R;

import java.util.List;

public class ListSubCateAdapter extends RecyclerView.Adapter<ListSubCateAdapter.MyViewHolder> {
    private Context context;
    private List<SubCategory> listCate;
    private List<ImageSubCate> listImage;

    public ListSubCateAdapter(Context context, List<SubCategory> listCate, List<ImageSubCate> listImage) {
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
            categoryName = itemView.findViewById(R.id.subcategoryName);
            imageView = itemView.findViewById(R.id.imageSubCate);
            linearLayout = itemView.findViewById(R.id.layoutSubCate);
        }
    }

    @NonNull
    @Override
    public ListSubCateAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.subcate_layout, parent, false);
        return new ListSubCateAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListSubCateAdapter.MyViewHolder holder, final int position) {
        holder.categoryName.setText(listCate.get(position).getSubCategoryName());
        //  holder.imageView.setImageResource(listImage.get(position).getImageLink());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubCategory subCategory = listCate.get(position);
                Intent intent = new Intent(context, ListProductBySubCateActivity.class);
                intent.putExtra("subCate", subCategory);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCate.size();
    }

}
