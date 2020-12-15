package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.note.model.NoteItems;
import com.example.note.roomDataBase.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.main_btn_test);

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<NoteItems> list = new ArrayList<>();
                DatabaseClient.getInstance(getBaseContext()).getAppDatabase().roomInterface().deleteAllTable();
                for (int i = 0; i < 100; i++) {
                    //String titleNote, String bodyNote, String dateNote
                    NoteItems noteItems = new NoteItems("Write your title .", "\"This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\\n\n" +
                            "This is a body lab lab lab\\n lab lab \\n .......\"",
                                                            

                            "08 dec , 2020");
                    list.add(noteItems);

                }


                DatabaseClient.getInstance(getBaseContext()).getAppDatabase().roomInterface().insertListItems(list);
            }
        }).start();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getBaseContext(), MyNotes.class));
            }
        });

    }
}