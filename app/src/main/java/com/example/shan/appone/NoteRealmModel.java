package com.example.shan.appone;

import io.realm.RealmObject;

/**
 * Created by shan on 15.03.2018.
 */

public class NoteRealmModel extends RealmObject{
    private String noteTitle;
    private String noteContent;
    private String noteCreateDate;

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
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
