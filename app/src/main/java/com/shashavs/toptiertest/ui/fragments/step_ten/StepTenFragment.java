package com.shashavs.toptiertest.ui.fragments.step_ten;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shashavs.toptiertest.R;
import com.shashavs.toptiertest.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class StepTenFragment extends BaseFragment {

    private List<Item> itemList;
    private TextView titleTextView;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemList = new ArrayList<>();
        itemList.add(new Item(getString(R.string.item_1_title), getString(R.string.item_1_text)));
        itemList.add(new Item(getString(R.string.item_2_title), getString(R.string.item_2_text)));
        itemList.add(new Item(getString(R.string.item_3_title), getString(R.string.item_3_text)));
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

        titleTextView.setText(R.string.step_ten_title);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new StepTenAdapter(itemList));
    }
}
