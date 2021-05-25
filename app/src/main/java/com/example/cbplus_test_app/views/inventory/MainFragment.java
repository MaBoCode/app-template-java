package com.example.cbplus_test_app.views.inventory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cbplus_test_app.databinding.FrgMainBinding;
import com.example.cbplus_test_app.injects.base.BaseFragment;

import org.androidannotations.annotations.EFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@EFragment
public class MainFragment extends BaseFragment {

    protected FrgMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FrgMainBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void initObservers() {

    }

}
