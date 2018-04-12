package com.example.shan.appone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class NotesAdapterAsMainScreenPresenter extends RecyclerView.Adapter<NotesAdapterAsMainScreenPresenter.ViewHolder> {

    private Context mContext;
    //Cannot be null
    private  MainScreenInteractor mMainScreenInteractor = new MainScreenInteractor(MyApplication.getContext());

    // Store a member variable for the noteModels
    private List<NoteRealmModel> mNoteRealmModels = new ArrayList<>();

    // Pass in the contact array into the constructor
    public NotesAdapterAsMainScreenPresenter(Context context, List<NoteRealmModel> noteRealmModels) {
        mNoteRealmModels = mMainScreenInteractor.getNotes();
        mContext = context;
        Log.e("shan", "adapter construct");
    }
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder{

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView noteContentTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            noteContentTextView = (TextView) itemView.findViewById(R.id.note_content);
            noteContentTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getAdapterPosition();
                    Log.e("Shans","CLICK pos =" + itemPosition);
                    NoteRealmModel noteRealmModel = mNoteRealmModels.get(itemPosition);
                    int noteID = noteRealmModel.getNoteID();
                    Log.e("Shans","ID =" + noteRealmModel.getNoteID());
                    Intent intent = new Intent(mContext, EditNoteAcitivty.class);
                    intent.putExtra("noteID", noteID);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public NotesAdapterAsMainScreenPresenter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_note, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(NotesAdapterAsMainScreenPresenter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        NoteRealmModel noteRealmModel = mNoteRealmModels.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.noteContentTextView;
        textView.setText(noteRealmModel.getNoteContent());

        //Show ID in MainScreen
        //textView.setText(String.valueOf(noteRealmModel.getNoteID()));

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mNoteRealmModels.size();
    }
}