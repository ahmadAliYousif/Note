package com.example.note.roomDataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.note.interfaces.RoomInterface;
import com.example.note.model.NoteItems;
@Database(entities = {NoteItems.class}, version = 1)
public abstract class AppDateBase extends RoomDatabase {
    public abstract RoomInterface roomInterface();

}
