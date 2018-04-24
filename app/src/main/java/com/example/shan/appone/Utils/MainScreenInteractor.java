package com.example.shan.appone.Utils;

import android.content.Context;

import com.example.shan.appone.Data.NoteRealmModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by shan on 24.03.2018.
 */

public class MainScreenInteractor implements MainScreenContract.MainScreenInteractor {

    Realm realm;
    Context mContext;
    private List<NoteRealmModel> mNoteRealmModels = new ArrayList<>();

    public MainScreenInteractor(Context mContext) {
        this.mContext = mContext;
        Realm.init(mContext);
        realm = Realm.getDefaultInstance();
    }

    public List<NoteRealmModel> getNotes(){

        RealmResults<NoteRealmModel> results = realm.where(NoteRealmModel.class).findAll();

        for(NoteRealmModel noteRealmModel : results){
            //text.append(noteRealmModel. + " " + noteRealmModel.getName() + "\n");
            mNoteRealmModels.add(noteRealmModel);
        }
        return mNoteRealmModels;
    }
}
