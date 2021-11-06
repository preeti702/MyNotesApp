package com.preeti.mynotesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.preeti.mynotesapp.db.User;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.MyViewHolder> {

    public Context context;
    private List<User> noteList;

    public NotesListAdapter(Context context){
        this.context = context;

    }

    public void setNoteList(List<User> noteList){
        this.noteList = noteList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public NotesListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view_holder,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesListAdapter.MyViewHolder holder, int position) {
        holder.title.setText(this.noteList.get(position).note_title);
        holder.desc.setText(this.noteList.get(position).note_desc);

    }

    @Override
    public int getItemCount() {
        return   this.noteList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title , desc;
        public MyViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.list_title);
            desc = view.findViewById(R.id.list_desc);
        }
    }
}
