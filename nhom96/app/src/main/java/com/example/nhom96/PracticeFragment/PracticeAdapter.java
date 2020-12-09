package com.example.nhom96.PracticeFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom96.R;

import java.util.ArrayList;

import com.example.nhom96.PracticeFragment.datamodel;

public class PracticeAdapter extends RecyclerView.Adapter<PracticeAdapter.PracticeViewHolder> {

    ArrayList<datamodel> dataholder;
    public PracticeAdapter(ArrayList<datamodel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public PracticeAdapter.PracticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.practice_list_item,parent, false);
        return new PracticeAdapter.PracticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PracticeViewHolder holder, int position) {
        holder.imageView.setImageResource(dataholder.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class PracticeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public PracticeViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
