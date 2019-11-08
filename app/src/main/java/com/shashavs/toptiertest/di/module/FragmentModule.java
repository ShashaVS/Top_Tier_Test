package com.shashavs.toptiertest.di.module;

import com.shashavs.toptiertest.di.scope.FragmentScope;
import com.shashavs.toptiertest.ui.fragments.step_eleven.StepElevenFragment;
import com.shashavs.toptiertest.ui.fragments.StepPagerFragment;
import com.shashavs.toptiertest.ui.fragments.step_ten.StepTenFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract StepPagerFragment contributeStepPagerFragment();

    @FragmentScope
    @ContributesAndroidInjector
    abstract StepTenFragment contributeStepTenFragment();

    @FragmentScope
    @ContributesAndroidInjector
    abstract StepElevenFragment contributeStepElevenFragment();
}
