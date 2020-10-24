package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.R;


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
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleAccountDefault);
            imageView = itemView.findViewById(R.id.imageAccountDefault);
      //      linearLayout= itemView.findViewById(R.id.mainLayout);
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
    public void onBindViewHolder(@NonNull DefaultAccountAdapter.MyViewHolder holder, final int position) {
        holder.title.setText(data1[position]);
        holder.imageView.setImageResource(images[position]);
//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(context, SettingAccount.class);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

}
