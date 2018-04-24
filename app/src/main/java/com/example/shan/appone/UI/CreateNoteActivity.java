package com.example.shan.appone.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shan.appone.Utils.CreateNotesContract;
import com.example.shan.appone.R;


public class CreateNoteActivity extends AppCompatActivity implements CreateNotesContract.View {

    private Context mContext;
    private CreateNotesContract.View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        final CreateNotePresenter createNotePresenter = new CreateNotePresenter(this,this); //mContext, mView

        final EditText editTextNoteContent =  (EditText) findViewById(R.id.et_noteContent);

        //TODO create separated functions for button and other utils

        editTextNoteContent.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editTextNoteContent,InputMethodManager.SHOW_IMPLICIT);

        Button btnAddNote = (Button) findViewById(R.id.button_addNote);
        btnAddNote.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                createNotePresenter.createNote(editTextNoteContent.getText().toString());
                Intent mainScreenActivity = new Intent(CreateNoteActivity.this, MainScreenActivity.class);
                startActivity(mainScreenActivity);
            }
        });
    }

    @Override
    public void onError(String error){
        switch (error){
            case "validationError":
                Toast.makeText(mContext,"Field cannot be empty!",Toast.LENGTH_LONG).show();
        }
    }




}
