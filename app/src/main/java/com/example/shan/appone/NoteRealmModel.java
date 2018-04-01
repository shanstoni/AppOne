package com.example.shan.appone;

import io.realm.RealmObject;

/**
 * Created by shan on 15.03.2018.
 */

public class NoteRealmModel extends RealmObject{
    private int noteID;
    private String noteContent;
    private String noteCreateDate;

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getNoteCreateDate() {
        return noteCreateDate;
    }

    public void setNoteCreateDate(String noteCreateDate) {
        this.noteCreateDate = noteCreateDate;
    }

}
