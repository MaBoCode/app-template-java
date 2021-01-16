package com.example.app_template_java.injects.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app_template_java.App;

import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dagger.hilt.EntryPoints;
import dagger.hilt.android.AndroidEntryPoint;

public abstract class BaseFragment extends Fragment {

    protected Context appContext;
    protected Context uiContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appContext = App.getAppContext();
        uiContext = this.getActivity();

    }
}
