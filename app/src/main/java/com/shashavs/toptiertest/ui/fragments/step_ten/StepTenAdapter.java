package com.shashavs.toptiertest.ui.fragments.step_ten;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shashavs.toptiertest.R;

import java.util.List;

public class StepTenAdapter extends RecyclerView.Adapter<StepTenAdapter.ViewHolder> {

    private List<Item> itemList;

    StepTenAdapter(List<Item> data) {
        this.itemList = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_ten_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView text;

        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.item_title);
            text = view.findViewById(R.id.item_text);
        }

        void bind(Item item) {
            title.setText(item.getTitle());
            text.setText(item.getText());
        }
    }
}
