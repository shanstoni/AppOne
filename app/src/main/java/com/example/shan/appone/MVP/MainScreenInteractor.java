package com.example.shan.appone.MVP;

import android.content.Context;

import com.example.shan.appone.Activities.MainScreenContract;
import com.example.shan.appone.NoteRealmModel;

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

    public MainScreenInteractor(Context mContext) {
        this.mContext = mContext;
    }

    // Store a member variable for the noteRealmModels
    private List<NoteRealmModel> mNoteRealmModels = new ArrayList<>();

    public List<NoteRealmModel> getNotes(){

        Realm.init(mContext);
        realm = Realm.getDefaultInstance();

        RealmResults<NoteRealmModel> results = realm.where(NoteRealmModel.class).findAll();

        //text.setText("");

        for(NoteRealmModel noteRealmModel : results){
            //text.append(noteRealmModel. + " " + noteRealmModel.getName() + "\n");
            mNoteRealmModels.add(noteRealmModel);
        }
        return mNoteRealmModels;
    }
}
