package com.example.mynotebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mynotebook.adapter.MyRecyclerViewAdapter;
import com.example.mynotebook.model.Note;
import com.example.mynotebook.storage.NoteStorage;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ArrayList<Note> list;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private Context context;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        list=new ArrayList<>();
        list=NoteStorage.getList();

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter=new MyRecyclerViewAdapter(list,context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = list.indexOf(list.get(list.size()-1))+1;
                list.add(position,new Note("note",""));
                adapter.notifyItemInserted(position);
                recyclerView.scrollToPosition(position);
            }
        });
    }

}
