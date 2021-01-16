package com.example.app_template_java.injects.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;

import javax.inject.Inject;

import dagger.hilt.EntryPoints;
import dagger.hilt.android.AndroidEntryPoint;

public abstract class BaseActivity extends AppCompatActivity {

    protected Context appContext;
    protected Activity uiContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.appContext = getApplicationContext();
        this.uiContext = this;
    }

}
