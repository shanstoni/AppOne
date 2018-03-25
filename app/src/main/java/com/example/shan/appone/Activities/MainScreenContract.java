package com.example.shan.appone.Activities;

import com.example.shan.appone.NoteRealmModel;

import java.util.List;

/**
 * Created by shan on 24.03.2018.
 */

public interface MainScreenContract {

    interface MainScreenInteractor{

        public List<NoteRealmModel> getNotes();

        //public void getNote(int position);
    }
}
