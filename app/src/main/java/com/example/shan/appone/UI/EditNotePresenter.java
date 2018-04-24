package com.example.shan.appone.UI;

import android.content.Context;
import android.util.Log;

import com.example.shan.appone.Data.NoteRealmModel;
import com.example.shan.appone.Utils.EditNoteContract;
import com.example.shan.appone.Utils.EditNoteInteractor;

/**
 * Created by shan on 28.03.2018.
 */

public class EditNotePresenter {

    private Context mContext;
    int mNoteID;
    private NoteRealmModel mNoteRealmModel;
    private EditNoteContract.View mView;

    EditNoteInteractor editNoteInteractor =  new EditNoteInteractor(mContext);

    public EditNotePresenter(Context mContext, int noteID, EditNoteContract.View mView) {
        this.mContext = mContext;
        this.mView = mView;
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
            mView.onErrorMessage("emptyNote");
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
