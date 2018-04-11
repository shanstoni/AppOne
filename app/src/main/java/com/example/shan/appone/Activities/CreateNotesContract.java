package com.example.shan.appone.Activities;

import android.view.View;

import com.example.shan.appone.MVP.CreateNotePresenter;

/**
 * Created by shan on 18.03.2018.
 */

public interface CreateNotesContract {

    interface mainScreenView{

    }

    interface createNotesView{

        public void onError(String error);
        //public void setPresenter(CreateNotesContract.createNotesPresenter presenter);

    }

    interface createNotesPresenter{

    }

}
