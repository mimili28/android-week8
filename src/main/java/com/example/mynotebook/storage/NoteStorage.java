package com.example.mynotebook.storage;

import com.example.mynotebook.model.Note;

import java.util.ArrayList;

public class NoteStorage {
    private static ArrayList<Note> list;

    static {
        list = new ArrayList<>();
        list.add(new Note("Note 1","heyy"));
        list.add(new Note("Note 2","nicee"));
        list.add(new Note("Note 3","Have a good day"));
    }
    public static Note getNote(int index){
        return list.get(index);
    }

    public static int getLength(){
        return list.size();
    }
    public static ArrayList<Note> getList(){
        return list;
    }

}
