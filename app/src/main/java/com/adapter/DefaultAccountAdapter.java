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

import com.shopee.InformationAccountActivity;
import com.shopee.InformationShopActivity;
import com.shopee.R;
import com.shopee.SettingActivity;
import com.shopee.SupportActivity;


public class DefaultAccountAdapter extends RecyclerView.Adapter<DefaultAccountAdapter.MyViewHolder> {
    private String data1[];
    private Context context;
    private int images[];


    public DefaultAccountAdapter(Context context, String[] data1, int[] images) {
        this.data1 = data1;
        this.context = context;
        this.images = images;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleAccountDefault);
            imageView = itemView.findViewById(R.id.imageAccountDefault);
        }
    }

    @NonNull
    @Override
    public DefaultAccountAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.default_account, parent, false);
        return new DefaultAccountAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DefaultAccountAdapter.MyViewHolder holder, final int position) {
        holder.title.setText(data1[position]);
        holder.imageView.setImageResource(images[position]);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleStr = holder.title.getText().toString();
                switch (titleStr) {
                    case "Thiết lập tài khoản": {
                        Intent intent = new Intent(context, SettingActivity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Trung tâm trợ giúp": {
                        Intent intent = new Intent(context, SupportActivity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Giới thiệu": {
                        Intent intent = new Intent(context, InformationShopActivity.class);
                        context.startActivity(intent);
                        break;
                    }
                    default: {
                        Intent intent = new Intent(context, InformationAccountActivity.class);
                        context.startActivity(intent);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
