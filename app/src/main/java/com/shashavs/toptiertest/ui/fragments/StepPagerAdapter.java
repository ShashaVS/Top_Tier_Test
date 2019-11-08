package com.shashavs.toptiertest.ui.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shashavs.toptiertest.ui.fragments.step_eleven.StepElevenFragment;
import com.shashavs.toptiertest.ui.fragments.step_ten.StepTenFragment;

public class StepPagerAdapter extends FragmentStatePagerAdapter {

    StepPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new StepTenFragment();
            case 1:
                return new StepElevenFragment();
            default:
                return new StepTenFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

}
