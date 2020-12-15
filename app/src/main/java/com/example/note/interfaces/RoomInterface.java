package com.example.note.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.note.model.NoteItems;

import java.util.List;

@Dao
public interface RoomInterface {
    @Query("SELECT * FROM NoteItems")
    List<NoteItems> getAll();


    @Query("SELECT * FROM NoteItems WHERE id_note = :idNote")
    NoteItems searchById(int idNote);

    @Query("SELECT * FROM NoteItems WHERE title_note = :title")
    List<NoteItems> searchByName(String title);

    @Query("SELECT * FROM NoteItems WHERE date_note =:date")
    List<NoteItems> searchByDate(String date);


    @Query("DELETE FROM NoteItems")
    public void deleteAllTable();


    @Insert
    void insert(NoteItems NoteItems);

    @Insert
    void insertListItems(List<NoteItems> noteItemsList);

    @Delete
    void delete(NoteItems NoteItems);

    @Update
    void update(NoteItems NoteItems);
}
