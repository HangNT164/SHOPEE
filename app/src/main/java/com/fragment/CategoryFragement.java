package com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adapter.ListCateAdapter;
import com.dao.CategoryDao;
import com.dao.ImageCategoryDao;
import com.jdbc.RoomConnection;
import com.model.Category;
import com.model.ImageCategory;
import com.shopee.R;

import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.jdbc.RoomConnection.getInstance;

public class CategoryFragement extends Fragment {
    private RoomConnection roomConnection;
    private CategoryDao categoryDao;
    private ImageCategoryDao imageCategoryDao;
    private List<Category> listCate;
    private List<ImageCategory> listImageCate;
    private RecyclerView recyclerView;

    public CategoryFragement() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_category_fragement, container, false);

        roomConnection = getInstance(getApplicationContext());
        categoryDao = roomConnection.categoryDao();
        imageCategoryDao = roomConnection.imageCategoryDao();
        listCate = categoryDao.getAll();

        recyclerView = view.findViewById(R.id.listCategory);

        if (listCate.size() > 0) {
            ListCateAdapter listCateAdapter = new ListCateAdapter(getContext(), listCate, listImageCate);
            recyclerView.setAdapter(listCateAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        return view;
    }

}
