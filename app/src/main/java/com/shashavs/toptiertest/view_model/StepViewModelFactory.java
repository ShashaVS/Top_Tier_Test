package com.shashavs.toptiertest.view_model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.shashavs.toptiertest.data.api.ApiService;

import javax.inject.Inject;

public class StepViewModelFactory implements ViewModelProvider.Factory {

    private ApiService apiService;

    @Inject
    public StepViewModelFactory(ApiService apiService) {
        this.apiService = apiService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new StepViewModel(apiService);
    }
}
