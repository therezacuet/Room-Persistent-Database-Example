package com.thereza.roompersistencedbexample.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.thereza.roompersistencedbexample.data.entity.UserDbModel;

import java.util.List;

/**
 * Created by theReza on 7/4/2018.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM UserDbModel ORDER BY id DESC")
    List<UserDbModel> getAll();

    @Query("SELECT * FROM UserDbModel WHERE name LIKE :name ORDER BY id DESC")
    List<UserDbModel> findByName(String name);

    @Insert
    void insertAll(List<UserDbModel> products);

    @Update
    void update(UserDbModel product);

    @Delete
    void delete(UserDbModel product);

    @Query("DELETE FROM UserDbModel")
    void clearAll();
}