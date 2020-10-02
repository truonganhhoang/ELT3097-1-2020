package com.example.my_note;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_note.Model.Note;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater ;
    List<Note> Notes;

    Adapter(Context context , List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.Notes = notes;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_listview , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        String title =  Notes.get(position).getTitle();
        String date = Notes.get(position).getDate();
        String time = Notes.get(position).getTime();
        long id = Notes.get(position).getID();

        holder.ntitle.setText(title);
        holder.ndate.setText(date);
        holder.ntime.setText(time);
        holder.nID.setText(String.valueOf(Notes.get(position).getID()));
    }

    @Override
    public int getItemCount() {
        return Notes.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView ntitle , ndate , ntime, nID;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ntitle = itemView.findViewById(R.id.ntitle);
            ndate = itemView.findViewById(R.id.date);
            ntime = itemView.findViewById(R.id.time);
            nID=itemView.findViewById(R.id.listId);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //lay ra duoc vi tri hien tai
                    int position = getLayoutPosition();
                    //lay ra duoc doi tuong note tai position
                    Note note = Notes.get(position);
                    Intent i = new Intent(v.getContext(), Details.class);
                    //lay ra duoc id
                    i.putExtra("ID", note.getID());
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
