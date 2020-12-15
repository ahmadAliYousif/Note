package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.note.model.NoteItems;

public class DetailsNote extends AppCompatActivity {
    TextView tv_title, tv_date, tv_body;
    NoteItems noteItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_note);
        tv_body = findViewById(R.id.details_note_tv_body);
        tv_date = findViewById(R.id.details_note_tv_date);
        tv_title = findViewById(R.id.details_note_tv_title);
        Intent intent = getIntent();
        noteItems = (NoteItems) intent.getSerializableExtra("det_note");

        tv_title.setText(noteItems.getTitleNote());
        tv_date.setText(noteItems.getDateNote());
        tv_body.setText(noteItems.getBodyNote());
    }
}