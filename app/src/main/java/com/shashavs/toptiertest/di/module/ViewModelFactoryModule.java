package com.shashavs.toptiertest.di.module;

import com.shashavs.toptiertest.di.scope.ActivityScope;
import com.shashavs.toptiertest.view_model.StepViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
abstract class ViewModelFactoryModule {

    @ActivityScope
    @Binds
    abstract StepViewModelFactory getStepViewModelFactory(StepViewModelFactory stepViewModelFactory);
}
