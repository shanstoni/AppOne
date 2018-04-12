package com.example.shan.appone;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

/**
 * Created by shan on 18.03.2018.
 */

public class CreateNotePresenter{

    private Context mContext;
    private CreateNotesContract.createNotesView mCreateNotesView;
    private CreateNoteInteractor createNoteInteractor;
    private Realm realm;
    private View mView;

    public CreateNotePresenter(Context context, CreateNotesContract.createNotesView mCreateNotesView) {
        this.mContext = context;
        this.mCreateNotesView = mCreateNotesView;

        //mCreateNotesView.setPresenter(this);
    }

    public void createNote(String noteContent){

        CreateNoteInteractor createNoteInteractor = new CreateNoteInteractor(mContext);

        Realm.init(mContext);
        realm = Realm.getDefaultInstance();

        Log.e("Shan","przed walidacja");

        if (noteContent.isEmpty()){
            //mCreateNotesView.onError("validationError");
            Log.e("Shan","po walidacji");
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateandTime = simpleDateFormat.format(new Date());

            createNoteInteractor.createNote(noteContent,currentDateandTime);
        }
    }
}
