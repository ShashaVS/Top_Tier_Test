package com.shashavs.toptiertest.ui.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.shashavs.toptiertest.R;
import com.shashavs.toptiertest.ui.base.BaseFragment;

public class StepPagerFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_step_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        ImageView backArrow = view.findViewById(R.id.back_arrow);

        StepPagerAdapter pagerAdapter = new StepPagerAdapter(requireFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager, true);

        backArrow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO impl onBack
                requireActivity().finish();
            }
        });
    }
}
