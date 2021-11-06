package com.preeti.mynotesapp.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * From user")
    List<User> getAllNotes ();

    @Insert
    void insertUser(User...users);

    @Delete
    void delete(User...user);
}
