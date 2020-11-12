package com.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adapter.ListSubCateAdapter;
import com.dao.ImageSubcateDao;
import com.dao.SubCategoryDao;
import com.jdbc.RoomConnection;
import com.model.ImageSubCate;
import com.model.SubCategory;
import com.shopee.R;
import com.util.Helper;

import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.jdbc.RoomConnection.getInstance;

public class ListSubCategoryFragment extends Fragment {
    private RoomConnection roomConnection;
    private SubCategoryDao subCategoryDao;
    private ImageSubcateDao imageSubCate;
    private List<SubCategory> listSubEven;
    private List<SubCategory> listSub;
    private List<SubCategory> listSubOdd;
    private List<ImageSubCate> listImageSubCates;
    private RecyclerView listSubFirst;
    private RecyclerView listSubSecond;
    private int cateID;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_subcategory_fragment, container, false);

        roomConnection = getInstance(getApplicationContext());

        subCategoryDao = roomConnection.subCategoryDao();
        imageSubCate = roomConnection.imageSubcateDao();
        imageSubCate = roomConnection.imageSubcateDao();

        listSub = subCategoryDao.getAllByCategory(1);
        listSubEven = new Helper().getListSubCateByIndex(listSub, 1);
        listSubOdd = new Helper().getListSubCateByIndex(listSub, 2);

        listSubFirst = view.findViewById(R.id.listSubFirst);
        listSubSecond = view.findViewById(R.id.listSubSecond);

        if (listSubEven.size() > 0 && listSubOdd.size() > 0) {
            ListSubCateAdapter listCateAdapter = new ListSubCateAdapter(getContext(), listSubEven, listImageSubCates);
            listSubFirst.setAdapter(listCateAdapter);
            listSubFirst.setLayoutManager(new LinearLayoutManager(getContext()));

            ListSubCateAdapter listCateAdapterSecond = new ListSubCateAdapter(getContext(), listSubOdd, listImageSubCates);
            listSubSecond.setAdapter(listCateAdapterSecond);
            listSubSecond.setLayoutManager(new LinearLayoutManager(getContext()));

            listSubFirst.setNestedScrollingEnabled(false);
            listSubSecond.setNestedScrollingEnabled(false);
        }
        return view;
    }

}
