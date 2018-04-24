package com.example.shan.appone.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.shan.appone.Utils.CreateNotesContract;
import com.example.shan.appone.Data.NoteRealmModel;
import com.example.shan.appone.Utils.MyApplication;
import com.example.shan.appone.R;
import com.example.shan.appone.Utils.RecyclerItemClickListener;

import java.util.List;


public class MainScreenActivity extends AppCompatActivity implements CreateNotesContract.View {

    List<NoteRealmModel> mNoteRealmModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        InitAdapter();
        InitFloatingButton();
    }

    private void InitAdapter(){
    RecyclerView rvNotes = (RecyclerView) findViewById(R.id.rvContacts);
    Context context = MyApplication.getContext();
    final NotesAdapterAsMainScreenPresenter adapter = new NotesAdapterAsMainScreenPresenter(context, mNoteRealmModels);
    rvNotes.setAdapter(adapter);
    rvNotes.setLayoutManager(new LinearLayoutManager(context));
    rvNotes.addOnItemTouchListener(new RecyclerItemClickListener(MainScreenActivity.this, rvNotes,
            new RecyclerItemClickListener.OnItemClickListener() {

                @Override
                public void onItemClick(View view, int position) {
                }

                @Override
                public void onItemLongClick(View view, int position) {
                    Toast.makeText(MainScreenActivity.this, "LONG Touched!!", Toast.LENGTH_SHORT).show();
                }
            }));

    RecyclerView.ItemDecoration itemDecorationVertical = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
    RecyclerView.ItemDecoration itemDecorationHorizontal = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
    rvNotes.addItemDecoration(itemDecorationVertical);
    rvNotes.addItemDecoration(itemDecorationHorizontal);
    }

    private void InitFloatingButton(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createNoteActivity = new Intent(MainScreenActivity.this, CreateNoteActivity.class);
                startActivity(createNoteActivity);
            }
        });

    }


    @Override
    public void onErrorMessage(String error) {

    }
}