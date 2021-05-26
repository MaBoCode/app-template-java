package com.example.app_template_java.views.base;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;

import org.jetbrains.annotations.NotNull;

public abstract class BaseRecyclerViewAdapter<T, V extends ViewBinding> extends ListAdapter<T, BaseViewHolder<T, V>> {

    public BaseRecyclerViewAdapter(@NonNull @NotNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @NotNull
    @Override
    public abstract BaseViewHolder<T, V> onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull @NotNull BaseViewHolder<T, V> holder, int position) {
        T item = getItem(position);
        holder.bind(item);
    }
}
