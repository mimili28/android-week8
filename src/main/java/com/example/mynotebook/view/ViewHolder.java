package com.example.mynotebook.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotebook.Main2Activity;
import com.example.mynotebook.R;
import com.example.mynotebook.model.Note;
import com.example.mynotebook.storage.NoteStorage;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;
    private Context context;
    private ArrayList<Note> list;
    public int position;


    public ViewHolder(@NonNull View itemView){
        super(itemView);
        LinearLayout linearLayout=(LinearLayout) itemView;
        list= new ArrayList<>();
        context = itemView.getContext();
        textView = linearLayout.findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("position",position);
                intent.putExtra("note",NoteStorage.getNote(position));
                context.startActivity(intent);
            }
        });


    }
    public void setData(int positionNum){
        position=positionNum;
        textView.setText(NoteStorage.getNote(position).getHeadline());
    }

}
