package com.example.cbplus_test_app.views;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.cbplus_test_app.R;
import com.example.cbplus_test_app.databinding.FrgSplashscreenBinding;
import com.example.cbplus_test_app.injects.base.BaseFragment;

import org.androidannotations.annotations.EFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@EFragment
public class SplashScreenFragment extends BaseFragment {

    protected FrgSplashscreenBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FrgSplashscreenBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.to_main_fragment);
            }
        }, 2500);
    }

    @Override
    public void initObservers() {

    }
}
