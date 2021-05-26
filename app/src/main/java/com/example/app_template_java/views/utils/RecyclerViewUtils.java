package com.example.app_template_java.views.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.app_template_java.views.base.BaseRecyclerViewAdapter;

public class RecyclerViewUtils {

    public static <T, V extends ViewBinding> void setupAdapter(RecyclerView recyclerView, LinearLayoutManager layoutManager, BaseRecyclerViewAdapter<T, V> adapter) {
        layoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
