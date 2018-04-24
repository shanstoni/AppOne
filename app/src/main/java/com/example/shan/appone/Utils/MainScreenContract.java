package com.example.shan.appone.Utils;

import com.example.shan.appone.Data.NoteRealmModel;

import java.util.List;

/**
 * Created by shan on 24.03.2018.
 */

public interface MainScreenContract {

    interface View { }
    interface Presenter {}

    interface MainScreenInteractor{

        public List<NoteRealmModel> getNotes();

        //public void getNote(int position);
    }
}
