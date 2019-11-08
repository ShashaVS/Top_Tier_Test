package com.shashavs.toptiertest.ui.fragments.step_eleven;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.shashavs.toptiertest.R;
import com.shashavs.toptiertest.data.entity.Uiname;
import com.shashavs.toptiertest.ui.base.BaseFragment;
import com.shashavs.toptiertest.view_model.StepViewModel;
import com.shashavs.toptiertest.view_model.StepViewModelFactory;

import java.util.List;

import javax.inject.Inject;

public class StepElevenFragment extends BaseFragment {

    private StepViewModel viewModel;
    @Inject
    StepViewModelFactory viewModelFactory;

    private TextView titleTextView;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get(StepViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_step, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titleTextView = view.findViewById(R.id.text_title);
        recyclerView = view.findViewById(R.id.step_ten_list);
        progressBar = view.findViewById(R.id.progress_bar);

        titleTextView.setText(R.string.step_eleven_title);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        progressBar.setVisibility(View.VISIBLE);
        viewModel.getResultLiveData().observe(getViewLifecycleOwner(), new Observer<List<Uiname>>() {
            @Override
            public void onChanged(List<Uiname> uinameList) {
                if (uinameList != null) {
                    recyclerView.setAdapter(new StepElevenAdapter(uinameList));
                } else {
                    Snackbar.make(requireView(), R.string.error_message, Snackbar.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
