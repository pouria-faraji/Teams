package com.forza.home.assignments.teams.application;

import android.app.Application;
import android.content.Context;

import com.forza.home.assignments.teams.model.DB.DaoMaster;
import com.forza.home.assignments.teams.model.DB.DaoSession;

/**
 * Created by p.faraji on 2/8/2018.
 */

public class App extends Application {
    private static Context context;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "teams_DB");
        org.greenrobot.greendao.database.Database db =  helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

    }


    public static DaoSession getDaoSession() {
        return daoSession;
    }

    public static Context getAppContext() {
        return App.context;
    }
}
