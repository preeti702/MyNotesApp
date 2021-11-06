package com.preeti.mynotesapp.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "note_title")
    public String note_title;

    @ColumnInfo(name = "note_desc")
    public String note_desc;

    @ColumnInfo(name = "note_date")
    public String note_date;

}
