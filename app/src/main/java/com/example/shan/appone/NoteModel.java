package com.example.shan.appone;

import java.util.ArrayList;

/**
 * Created by shan on 03.03.2018.
 */

public class NoteModel {
    private String mNoteTitle;
    private String mNote;

    static ArrayList<NoteModel> noteModels = new ArrayList<NoteModel>();

    public String getmNote() {
        return mNote;
    }

    public void setmNote(String mNote) {
        this.mNote = mNote;
    }


    public NoteModel(String mNoteTitle, String mNote) {
        this.mNoteTitle = mNoteTitle;
        this.mNote = mNote;
    }

    public String getNote() {
        return mNoteTitle;
    }


    private static int lastNoteId = 0;

    public static ArrayList<NoteModel> createNotesList(int numNotes) {


        for (int i = 1; i <= numNotes; i++) {
            noteModels.add(new NoteModel("Note " + ++lastNoteId, Resources.lorem ));

        }

        return noteModels;
    }

    public static void createNote(String title, String content){
        noteModels.add(new NoteModel(title + " " + ++lastNoteId, content ));

    }
}
