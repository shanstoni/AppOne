package com.example.shan.appone.Utils;

import android.content.Context;

import com.example.shan.appone.Data.NoteRealmModel;

import io.realm.Realm;

/**
 * Created by shan on 28.03.2018.
 */

public class EditNoteInteractor {

    Realm realm;
    Context mContext;

    public EditNoteInteractor(Context mContext) {
        this.mContext = mContext;
    }

    private  NoteRealmModel noteRealmModel = new NoteRealmModel();

    public NoteRealmModel getNoteByID(int noteID){

        Realm.init(mContext);
        realm = Realm.getDefaultInstance();

        //RealmResults<NoteRealmModel> results = realm.where(NoteRealmModel.class).equalTo("noteID",noteID).findAll();

        return realm.where(NoteRealmModel.class).equalTo("noteID",noteID).findFirst();
    }

    public void updateNoteByID(String editNoteContext, int noteID){
        Realm.init(mContext);
        realm = Realm.getDefaultInstance();

        NoteRealmModel result =  realm.where(NoteRealmModel.class).equalTo("noteID", noteID).findFirst();

        realm.beginTransaction();
        result.setNoteContent(editNoteContext);
        realm.commitTransaction();
    }

    public void deleteNoteByID(int noteID){
        Realm.init(mContext);
        realm = Realm.getDefaultInstance();

        NoteRealmModel result =  realm.where(NoteRealmModel.class).equalTo("noteID", noteID).findFirst();
        realm.beginTransaction();
        result.deleteFromRealm();
        realm.commitTransaction();
    }


}
