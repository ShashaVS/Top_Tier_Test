package com.shashavs.toptiertest.ui.base;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import dagger.android.support.AndroidSupportInjection;

public class BaseFragment extends Fragment {

    public BaseFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
