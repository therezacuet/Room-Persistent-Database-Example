package com.thereza.roompersistencedbexample.data.loaders;

import android.content.Context;
import android.os.AsyncTask;

import com.thereza.roompersistencedbexample.data.entity.UserDbModel;
import com.thereza.roompersistencedbexample.data.helpers.AppDb;
import com.thereza.roompersistencedbexample.data.helpers.DaoHelper;
import com.thereza.roompersistencedbexample.data.helpers.DbLoaderInterface;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by theReza on 7/4/2018.
 */

public class UserDbLoader extends AsyncTask<Object, Void, Object> {

    private DbLoaderInterface dbLoaderInterface;
    private WeakReference<Context> weakContext;

    public UserDbLoader(Context context) {
        weakContext = new WeakReference<Context>(context);
    }

    public void setDbLoaderInterface(DbLoaderInterface dbLoaderInterface) {
        this.dbLoaderInterface = dbLoaderInterface;
    }

    @Override
    protected Object doInBackground(Object... object) {
        Context context = weakContext.get();
        int command = (int) object[0];

        if (command == DaoHelper.INSERT_ALL) {
            List<UserDbModel> userDbModels = (List<UserDbModel>) object[1];
            AppDb.getAppDb(context).getUserDao().insertAll(userDbModels);
        } else if (command == DaoHelper.FETCH_ALL) {
            return AppDb.getAppDb(context).getUserDao().getAll();
        } else if (command == DaoHelper.DELETE) {
            UserDbModel userDbModel = (UserDbModel) object[1];
            AppDb.getAppDb(context).getUserDao().delete(userDbModel);
        } else if (command == DaoHelper.SEARCH) {
            String name = (String) object[1];
            return AppDb.getAppDb(context).getUserDao().findByName(name);
        } else if (command == DaoHelper.EDIT) {
            UserDbModel userDbModel = (UserDbModel) object[1];
            AppDb.getAppDb(context).getUserDao().update(userDbModel);
        } else if (command == DaoHelper.DELETE_ALL) {
            AppDb.getAppDb(context).getUserDao().clearAll();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        if(dbLoaderInterface != null) {
            dbLoaderInterface.onFinished(o);
        }
    }
}