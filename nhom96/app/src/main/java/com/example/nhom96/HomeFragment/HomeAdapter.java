package com.example.nhom96.HomeFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom96.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{

    ArrayList<com.example.nhom96.HomeFragment.datamodel> dataholder;

    public HomeAdapter(ArrayList<com.example.nhom96.HomeFragment.datamodel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item,parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        holder.imageView.setImageResource(dataholder.get(position).getImage());
        holder.header.setText(dataholder.get(position).getHeader());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView header;

        public HomeViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            header = itemView.findViewById(R.id.text_view);
        }
    }
}
