package com.example.mynotebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotebook.model.Note;
import com.example.mynotebook.R;
import com.example.mynotebook.view.ViewHolder;

import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Note> list;
    private Context context;


    public MyRecyclerViewAdapter(ArrayList<Note> list, Context context){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.
                from(parent.getContext()).inflate(R.layout.customrow, parent, false);
        return new ViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
       holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
