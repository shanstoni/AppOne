package com.example.shan.appone.MVP;

import android.content.Context;
import android.util.Log;
import android.widget.Button;

import com.example.shan.appone.NoteRealmModel;

import io.realm.Realm;

/**
 * Created by shan on 28.03.2018.
 */

public class EditNotePresenter {

    Context mContext;
    int mNoteID;
    NoteRealmModel mNoteRealmModel;

    EditNoteInteractor editNoteInteractor =  new EditNoteInteractor(mContext);

    public EditNotePresenter(Context mContext, int noteID) {
        this.mContext = mContext;
        mNoteRealmModel = editNoteInteractor.getNoteByID(noteID);
        setmNoteID(noteID);
    }

    public String getNoteCreateDate(){
        String mCreateNoteDate = mNoteRealmModel.getNoteCreateDate();
        return mCreateNoteDate;
    }

    public String getNoteContent(){
        String mNoteContent = mNoteRealmModel.getNoteContent();
        return mNoteContent;
    }

    public void updateNoteByID(String editNoteContent, int noteID){
        if (editNoteContent.isEmpty()) {
            Log.v("Shan","empty content? = "+editNoteContent);
            //TODO onError
        } else {
           editNoteInteractor.updateNoteByID(editNoteContent,noteID);
        }
    }

    public void deleteNoteByID(int noteID){
        editNoteInteractor.deleteNoteByID(noteID);
    }

    public void setmNoteID(int mNoteID) {
        this.mNoteID = mNoteID;
    }
}
