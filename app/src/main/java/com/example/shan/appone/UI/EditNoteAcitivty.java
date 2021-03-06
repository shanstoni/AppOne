package com.example.shan.appone.UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shan.appone.R;
import com.example.shan.appone.Utils.EditNoteContract;

public class EditNoteAcitivty extends AppCompatActivity implements EditNoteContract.View {

    private TextView tvCreateNoteDate;
    private EditText etEditNote;
    private Context mContext;
    private Button updateNoteButton;
    private Button deleteNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note_acitivty);

        final int noteID = getIntent().getIntExtra("noteID",0);

        final EditNotePresenter editNotePresenter = new EditNotePresenter(mContext,noteID,this);

        tvCreateNoteDate = (TextView) findViewById(R.id.tv_noteDate);
        etEditNote = (EditText) findViewById(R.id.et_editNote);

        tvCreateNoteDate.setText(editNotePresenter.getNoteCreateDate());
        etEditNote.setText(editNotePresenter.getNoteContent());

        updateNoteButton = (Button) findViewById(R.id.button_update_note);
        updateNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNotePresenter.updateNoteByID(etEditNote.getText().toString(),noteID);
                Intent intent = new Intent(EditNoteAcitivty.this,MainScreenActivity.class);
                startActivity(intent);
            }
        });

        deleteNoteButton = (Button) findViewById(R.id.button_delete_note);
        deleteNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNotePresenter.deleteNoteByID(noteID);
                Intent intent = new Intent(EditNoteAcitivty.this, MainScreenActivity.class);
                startActivity(intent);
                Toast.makeText(EditNoteAcitivty.this,"Note removed",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onErrorMessage(String error) {
        switch (error){
            case "emptyNote":
                Toast.makeText(getApplicationContext(),"Note cannot be empty!",Toast.LENGTH_LONG).show();
        }
    }
}
