package com.example.shan.appone;

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

import java.util.List;


public class MainScreenActivity extends AppCompatActivity implements CreateNotesContract {

    List<NoteRealmModel> noteRealmModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        //Recyclerview in activity layout
        //Get application context
        //Create adapter passing in data
        //Attach the adapter to the recyclerview to populate items
        //Set layout manager to position the items

        RecyclerView rvNotes = (RecyclerView) findViewById(R.id.rvContacts);
        Context mContext = MyApplication.getContext();
        final NotesAdapterAsMainScreenPresenter adapter = new NotesAdapterAsMainScreenPresenter(mContext, noteRealmModels);
        rvNotes.setAdapter(adapter);
        Log.e("Shans", "adapter setted");
        rvNotes.setLayoutManager(new LinearLayoutManager(mContext));
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createNoteActivity = new Intent(MainScreenActivity.this, CreateNoteActivity.class);
                startActivity(createNoteActivity);
            }
        });

        RecyclerView.ItemDecoration itemDecorationVertical = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerView.ItemDecoration itemDecorationHorizontal = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        rvNotes.addItemDecoration(itemDecorationVertical);
        rvNotes.addItemDecoration(itemDecorationHorizontal);

        //Change layout!
        //StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        // Attach the layout manager to the recycler view
        //rvNotes.setLayoutManager(gridLayoutManager);

    }
}