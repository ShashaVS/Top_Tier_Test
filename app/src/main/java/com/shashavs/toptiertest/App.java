package com.shashavs.toptiertest;

import android.app.Activity;
import android.app.Application;

import com.shashavs.toptiertest.di.component.DaggerAppComponent;
import com.shashavs.toptiertest.di.module.AppModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .applicationBind(this)
                .appModule(new AppModule())
                .build()
                .inject(this);
    }

}
