package com.shashavs.toptiertest.di.module;

import com.shashavs.toptiertest.di.scope.ActivityScope;
import com.shashavs.toptiertest.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = ViewModelFactoryModule.class)
    abstract MainActivity contributeActivityAndroidInjector();
}
