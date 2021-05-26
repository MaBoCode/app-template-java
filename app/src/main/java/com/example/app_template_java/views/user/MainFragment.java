package com.example.app_template_java.views.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_template_java.core.user.User;
import com.example.app_template_java.databinding.FrgMainBinding;
import com.example.app_template_java.injects.base.BaseFragment;
import com.example.app_template_java.injects.base.BaseViewModel.LoadingStatus;
import com.example.app_template_java.views.user.utils.UserAdapter;
import com.example.app_template_java.views.utils.RecyclerViewUtils;

import org.androidannotations.annotations.EFragment;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
@EFragment
public class MainFragment extends BaseFragment {

    protected FrgMainBinding binding;

    protected MainFragmentViewModel viewModel;

    protected UserAdapter userAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        binding = FrgMainBinding.inflate(inflater, container, false);

        setupUserAdapter();

        return binding.getRoot();
    }

    public void setupUserAdapter() {
        this.userAdapter = new UserAdapter(new User.UserDiff());
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        RecyclerViewUtils.setupAdapter(binding.userRecyclerView, layoutManager, userAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        viewModel.getUsers();
    }

    @Override
    public void initViewModels() {
        viewModel = new ViewModelProvider(this).get(MainFragmentViewModel.class);
    }

    @Override
    public void subscribeObservers() {
        viewModel.usersLiveData.observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter.submitList(users);
            }
        });

        viewModel.loadingLiveData.observe(getViewLifecycleOwner(), new Observer<LoadingStatus>() {
            @Override
            public void onChanged(LoadingStatus status) {
                showHideLoader(requireActivity(), status);
            }
        });
    }

    @Override
    public void unsubscribeObservers() {
        viewModel.usersLiveData.removeObservers(getViewLifecycleOwner());
        viewModel.loadingLiveData.removeObservers(getViewLifecycleOwner());
    }
}
