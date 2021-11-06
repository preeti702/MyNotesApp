package com.preeti.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.preeti.mynotesapp.db.AppDatabase;
import com.preeti.mynotesapp.db.User;

public class AddNewNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);

        EditText ed_title = findViewById(R.id.ed_note_title);
        EditText ed_desc = findViewById(R.id.ed_note_desc);
        Button btn_save_notes = findViewById(R.id.btn_save_notes);

        btn_save_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title= ed_title.getText().toString();
                String desc = ed_desc.getText().toString();
                saveNewRow(title,desc);
            }
        });
    }
    public  void saveNewRow(String title, String desc){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        User user = new User();
        user.note_title = title;
        user.note_desc = desc;
        db.userDao().insertUser(user);

        finish();
    }
}
