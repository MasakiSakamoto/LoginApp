package com.masakisakamoto.loginapp;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by masakisakamoto on 7/28/17.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    /**
     * バージョンコードの取得
     *
     * @param context
     * @return
     */

    public static int getVersionCode(Context context){
        PackageManager pm = context.getPackageManager();
        int versionCode = 0;
        try{
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * バージョン名取得
     *
     * @param context
     * @return
     */

    public static String getVersionName(Context context) {
        PackageManager pm =context.getPackageManager();
        String versionName = "";
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
