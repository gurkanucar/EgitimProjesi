package com.gucarsoft.egitimprojesi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.gucarsoft.egitimprojesi.R;
import com.gucarsoft.egitimprojesi.model.SoruModel;

import java.util.Collections;
import java.util.List;

public class SoruModelRCViewAdapter extends RecyclerView.Adapter<SoruModelRCViewAdapter.ViewHolder> {

    private static List<SoruModel> list;
    private Context context;

    public SoruModelRCViewAdapter(List<SoruModel> list) {
        Collections.reverse(list);
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.soru_takip_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.goal.setText(list.get(position).getGoal()+"");
        holder.done.setText(list.get(position).getDone()+"");
        holder.left.setText(list.get(position).getGoal()-list.get(position).getDone()+"");
        int progressValue =(int) (100*list.get(position).getDone()/list.get(position).getGoal());
        if (progressValue<2){
            holder.progressBar.setProgress(1);
        }
        else{
            holder.progressBar.setProgress(progressValue);
        }

        holder.viewProgress.setText("%"+progressValue);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayout;
        TextView name;
        TextView goal;
        TextView done;
        TextView left;
        TextView viewProgress;
        ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.soru_takip_item_constraint_layout);
            name = itemView.findViewById(R.id.soru_takip_baslik);
            goal = itemView.findViewById(R.id.soru_takip_hedef);
            done = itemView.findViewById(R.id.soru_takip_cozulen);
            left = itemView.findViewById(R.id.soru_takip_kalan);
            viewProgress = itemView.findViewById(R.id.text_view_progress);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }

}
