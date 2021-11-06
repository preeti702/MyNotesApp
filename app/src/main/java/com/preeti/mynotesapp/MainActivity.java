package com.preeti.mynotesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.preeti.mynotesapp.db.AppDatabase;
import com.preeti.mynotesapp.db.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NotesListAdapter notesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_add_note = findViewById(R.id.btn_add_notes);


        btn_add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  startActivityForResult(new Intent(MainActivity.this,AddNewNote.class),100);
                startNewAct();

            }
        });

        inRecyclerView();

        loadNotesList();
    }
    public void startNewAct(){
        Intent intent = new Intent(this,AddNewNote.class);
        startActivityForResult(intent,100);

    }

    private void inRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.list_notes_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        notesListAdapter = new NotesListAdapter(this);
        recyclerView.setAdapter(notesListAdapter);

    }

    private void loadNotesList(){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<User> listNotes =db.userDao().getAllNotes();
        notesListAdapter.setNoteList(listNotes);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100)
        {
            loadNotesList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}