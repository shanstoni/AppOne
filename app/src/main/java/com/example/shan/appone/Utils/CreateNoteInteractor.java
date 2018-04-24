package com.example.shan.appone.Utils;

import android.util.Log;

import com.example.shan.appone.Data.NoteRealmModel;

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

    public void createNote(String noteContent, String noteCreateDate){

        Realm.init(mContext);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

//        realm.executeTransactionAsync(new Realm.Transaction() {
//              @Override
//              public void execute(Realm bgRealm) {
//                  // Get the current max id in the users table
//                  Number maxId = bgRealm.where(NoteRealmModel.class).max("id");
//                  // If there are no rows, currentId is null, so the next id must be 1
//                  // If currentId is not null, increment it by 1
//                  int nextId = (maxId == null) ? 1 : maxId.intValue() + 1;
//                  // User object created with the new Primary key
//                  NoteRealmModel noteRealmModel = bgRealm.createObject(NoteRealmModel.class, nextId);
//                  // Now you can update your object with your data. The object will be
//                  // automatically saved in the database when the execute method ends
//
//              }
//          });

        Number maxId = realm.where(NoteRealmModel.class).max("noteID");
        int nextId = (maxId == null) ? 1 : maxId.intValue() + 1;

        NoteRealmModel noteRealmModel = realm.createObject(NoteRealmModel.class);
        noteRealmModel.setNoteID(nextId);
        noteRealmModel.setNoteContent(noteContent);
        noteRealmModel.setNoteCreateDate(noteCreateDate);

        realm.commitTransaction();

    }
}
