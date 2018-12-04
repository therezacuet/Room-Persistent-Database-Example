package com.thereza.roompersistencedbexample.data.helpers;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by theReza on 7/4/2018.
 */

public class AppDb {

    private static DaoHelper daoHelper;

    public static DaoHelper getAppDb(Context context) {
        if(daoHelper == null) {
            daoHelper = Room.databaseBuilder(context, DaoHelper.class, DaoHelper.DATABASE_NAME).build();
        }
        return daoHelper;
    }
}