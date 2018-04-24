package com.example.shan.appone.UI;

import android.content.Context;
import android.util.Log;

import com.example.shan.appone.Utils.CreateNoteInteractor;
import com.example.shan.appone.Utils.CreateNotesContract;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

/**
 * Created by shan on 18.03.2018.
 */

public class CreateNotePresenter{

    private Context mContext;
    private CreateNotesContract.View mView;
    private CreateNoteInteractor createNoteInteractor;
    private Realm realm;

    public CreateNotePresenter(Context context, CreateNotesContract.View mView) {
        this.mContext = context;
        this.mView = mView;

        //mView.setPresenter(this);
    }

    public void createNote(String noteContent){

        CreateNoteInteractor createNoteInteractor = new CreateNoteInteractor(mContext);

        Realm.init(mContext);
        realm = Realm.getDefaultInstance();

        Log.e("Shan","przed walidacja");

        if (noteContent.isEmpty()){
            //mView.onError("validationError");
            Log.e("Shan","po walidacji");
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateandTime = simpleDateFormat.format(new Date());

            createNoteInteractor.createNote(noteContent,currentDateandTime);
        }
    }
}
