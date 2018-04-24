package com.example.shan.appone.Utils;

/**
 * Created by shan on 18.03.2018.
 */

public interface CreateNotesContract {

    interface mainScreenView{

    }

    interface View {

        public void onError(String error);
        //public void setPresenter(CreateNotesContract.createNotesPresenter presenter);

    }

    interface createNotesPresenter{

    }

}
