package com.example.cbplus_test_app.views;

import android.os.Bundle;

import com.example.cbplus_test_app.databinding.ActMainBinding;
import com.example.cbplus_test_app.injects.base.BaseActivity;

import org.androidannotations.annotations.EActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@EActivity
public class MainActivity extends BaseActivity {

    protected ActMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}