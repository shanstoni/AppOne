package com.example.shan.appone.MVP;

import android.util.Log;

import com.example.shan.appone.NoteRealmModel;

import io.realm.Realm;


/**
 * Created by shan on 18.03.2018.
 */

public class CreateNoteInteractor {

    private android.content.Context mContext;
    Realm realm;

    public CreateNoteInteractor(android.content.Context mContext) {
        this.mContext = mContext;
    }

    public void createNote(String noteTitle, String noteContent, String noteCreateDate){

        Realm.init(mContext);
        realm = Realm.getDefaultInstance();

        Log.e("Shan","dodaje do bazy");

        realm.beginTransaction();

        NoteRealmModel noteRealmModel = realm.createObject(NoteRealmModel.class);
        noteRealmModel.setNoteTitle(noteTitle);
        noteRealmModel.setNoteContent(noteContent);
        noteRealmModel.setNoteCreateDate(noteCreateDate);

        realm.commitTransaction();

    }
}
