package com.example.shan.appone.MVP;

import android.content.Context;
import android.util.Log;

import com.example.shan.appone.Activities.CreateNotesContract;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shan on 18.03.2018.
 */

public class CreateNotePresenter{

    private Context mContext;
    private CreateNotesContract.createNotesView mCreateNotesView;
    private CreateNoteInteractor createNoteInteractor;




    public CreateNotePresenter(Context context, CreateNotesContract.createNotesView mCreateNotesView) {
        this.mContext = context;
        this.mCreateNotesView = mCreateNotesView;

        //mCreateNotesView.setPresenter(this);
    }

    public void createNote(String noteTitle, String noteContent){

        CreateNoteInteractor createNoteInteractor = new CreateNoteInteractor(mContext);


        Log.e("Shan","przed walidacja");

        if (noteTitle.isEmpty() || noteContent.isEmpty()){
            //mCreateNotesView.onError("validationError");
            Log.e("Shan","po walidacji");
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateandTime = simpleDateFormat.format(new Date());

            createNoteInteractor.createNote(noteTitle,noteContent,currentDateandTime);
        }


    }



}
