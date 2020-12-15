package com.example.note.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class NoteItems implements Serializable {
    @ColumnInfo(name = "id_note")
    @PrimaryKey(autoGenerate = true)
    private int idNote;
    @ColumnInfo(name = "title_note")
    private String titleNote;
    @ColumnInfo(name = "body_note")
    private String bodyNote;

    @ColumnInfo(name = "date_note")
    private String dateNote;

    public NoteItems() {
    }

    public NoteItems(int idNote, String titleNote, String bodyNote, String dateNote) {
        this.idNote = idNote;
        this.titleNote = titleNote;
        this.bodyNote = bodyNote;
        this.dateNote = dateNote;
    }
    public NoteItems(  String titleNote, String bodyNote, String dateNote) {

        this.titleNote = titleNote;
        this.bodyNote = bodyNote;
        this.dateNote = dateNote;
    }
    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getTitleNote() {
        return titleNote;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public String getBodyNote() {
        return bodyNote;
    }

    public void setBodyNote(String bodyNote) {
        this.bodyNote = bodyNote;
    }

    public String getDateNote() {
        return dateNote;
    }

    public void setDateNote(String dateNote) {
        this.dateNote = dateNote;
    }
}
