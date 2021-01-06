package com.example.egitimprojesi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egitimprojesi.R;
import com.example.egitimprojesi.model.LogModel;

import java.util.Collections;
import java.util.List;

public class LogModelRCViewAdapter extends RecyclerView.Adapter<LogModelRCViewAdapter.ViewHolder> {

    static List<LogModel> list;
    static Context context;

    public LogModelRCViewAdapter(List<LogModel> list) {
        Collections.reverse(list);
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.log_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.detail.setText(list.get(position).getDetail());
        holder.date.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout relativeLayout;
        TextView title;
        TextView detail;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.log_item_linear_layout);
            title = itemView.findViewById(R.id.log_item_title);
            detail = itemView.findViewById(R.id.log_item_detail);
            date = itemView.findViewById(R.id.log_item_date);
        }
    }
}
