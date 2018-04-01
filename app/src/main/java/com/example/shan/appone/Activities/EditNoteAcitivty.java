package com.example.shan.appone.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.shan.appone.MVP.EditNotePresenter;
import com.example.shan.appone.R;

public class EditNoteAcitivty extends AppCompatActivity {

    private TextView tvCreateNoteDate;
    private EditText etEditNote;
    private Context mContext;
    private Button updateNoteButton;
    private Button deleteNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note_acitivty);

        int noteID = getIntent().getIntExtra("noteID",0);
        Log.e("Shan", "received ID " + noteID);

        tvCreateNoteDate = (TextView) findViewById(R.id.tv_noteDate);
        etEditNote = (EditText) findViewById(R.id.et_editNote);

        tvCreateNoteDate.setText(EditNotePresenter.getNoteCreateDate);
        etEditNote.setText(EditNotePresenter.getNoteContent);

        updateNoteButton = (Button) findViewById(R.id.button_update_note);
        updateNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        deleteNoteButton = (Button) findViewById(R.id.button_delete_note);
        deleteNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

    }
}
