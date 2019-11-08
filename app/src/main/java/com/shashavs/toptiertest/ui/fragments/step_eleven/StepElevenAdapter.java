package com.shashavs.toptiertest.ui.fragments.step_eleven;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shashavs.toptiertest.R;
import com.shashavs.toptiertest.data.entity.Uiname;

import java.util.List;

public class StepElevenAdapter extends RecyclerView.Adapter<StepElevenAdapter.ViewHolder> {

    private List<Uiname> uinameList;

    StepElevenAdapter(List<Uiname> data) {
        this.uinameList = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_eleven_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uiname item = uinameList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return uinameList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleView;
        private TextView textView;

        ViewHolder(View view) {
            super(view);
            titleView = view.findViewById(R.id.item_title);
            textView = view.findViewById(R.id.item_text);
        }

        void bind(Uiname uiname) {
            String title = uiname.getSurname() + " " + uiname.getName();
            titleView.setText(title);
            textView.setText(textView.getContext().getString(R.string.years, uiname.getAge()));
        }
    }
}
