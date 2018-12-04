package com.thereza.roompersistencedbexample.data.helpers;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.thereza.roompersistencedbexample.data.dao.UserDao;
import com.thereza.roompersistencedbexample.data.entity.UserDbModel;

/**
 * Created by theReza on 7/4/2018.
 */

@Database(entities = {UserDbModel.class}, version = 1)
public abstract class DaoHelper extends RoomDatabase {
    public static final String DATABASE_NAME = "room-persistence.db";

    // commands
    public static final int INSERT_ALL = 1, FETCH_ALL = 2, DELETE = 3,
            SEARCH = 4, EDIT = 5, DELETE_ALL = 6;

    public abstract UserDao getUserDao();

}