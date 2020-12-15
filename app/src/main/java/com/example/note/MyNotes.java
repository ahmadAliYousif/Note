package com.example.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.note.interfaces.OnClickNote;
import com.example.note.interfaces.RoomInterface;
import com.example.note.model.NoteItems;
import com.example.note.roomDataBase.DatabaseClient;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class MyNotes extends AppCompatActivity {
    RecyclerView recyclerView;
    List<NoteItems> noteItems;
    RecycleViewItemsNote recycleViewItemsNote;
    RoomInterface roomInterface;
    Semaphore semaphore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        recyclerView = findViewById(R.id.my_notes_rc);
        roomInterface = DatabaseClient.getInstance(getBaseContext()).getAppDatabase().roomInterface();
        semaphore = new Semaphore(0);

        getNoteItems();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recycleViewItemsNote = new RecycleViewItemsNote(noteItems, getBaseContext(), new OnClickNote() {
            @Override
            public void onClick(NoteItems noteItems) {
                Intent intent = new Intent(getBaseContext(), DetailsNote.class);
                intent.putExtra("det_note", noteItems);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recycleViewItemsNote);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

    }

    private void getNoteItems() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                noteItems = roomInterface.getAll();
                semaphore.release();
            }
        }).start();

    }


}