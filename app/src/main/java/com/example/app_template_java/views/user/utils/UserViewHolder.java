package com.example.app_template_java.views.user.utils;

import com.example.app_template_java.core.user.User;
import com.example.app_template_java.databinding.UserListItemBinding;
import com.example.app_template_java.views.base.BaseViewHolder;

public class UserViewHolder extends BaseViewHolder<User, UserListItemBinding> {

    public UserViewHolder(UserListItemBinding binding) {
        super(binding);
    }

    @Override
    public void bind(User user) {
        binding.txtUsername.setText(user.username);
    }
}
