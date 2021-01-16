package com.example.app_template_java;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {

    private static WeakReference<Context> contextWeakReference;

    @Override
    public void onCreate() {
        super.onCreate();

        contextWeakReference = new WeakReference<>(getApplicationContext());

    }

    public static Context getAppContext() {
        return contextWeakReference.get();
    }

}
