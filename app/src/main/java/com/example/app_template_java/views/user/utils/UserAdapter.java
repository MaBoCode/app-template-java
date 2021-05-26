package com.example.app_template_java.views.user.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.app_template_java.core.user.User;
import com.example.app_template_java.databinding.UserListItemBinding;
import com.example.app_template_java.views.base.BaseRecyclerViewAdapter;
import com.example.app_template_java.views.base.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

public class UserAdapter extends BaseRecyclerViewAdapter<User, UserListItemBinding> {

    public UserAdapter(@NonNull @NotNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @NotNull
    @Override
    public BaseViewHolder<User, UserListItemBinding> onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        UserListItemBinding binding = UserListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new UserViewHolder(binding);
    }
}
