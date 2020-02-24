package com.example.mynotebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynotebook.adapter.MyRecyclerViewAdapter;
import com.example.mynotebook.model.Note;
import com.example.mynotebook.storage.NoteStorage;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private EditText editText_headline;
    private EditText editText_text;
    private Intent intent;
    private int position=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText_headline= findViewById(R.id.editText2);
        editText_text = findViewById(R.id.editText);

        intent= getIntent();
        position=intent.getIntExtra("position",0);

        editText_headline.setText(NoteStorage.getNote(position).getHeadline());
        editText_text.setText(NoteStorage.getNote(position).getText());
    }


    @Override
    protected void onPause(){
        super.onPause();
        NoteStorage.getNote(position).setHeadline(editText_headline.getText().toString());
        NoteStorage.getNote(position).setText(editText_text.getText().toString());

    }
}
