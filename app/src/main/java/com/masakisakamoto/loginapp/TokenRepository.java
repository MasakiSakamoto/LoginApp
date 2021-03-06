package com.masakisakamoto.loginapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by masakisakamoto on 7/28/17.
 */

public class TokenRepository {

    private static final String TAG = "TokenRepository";
    private static final String AUTH_TOKEN = "auth_token";

    private final Context context;
    private final SharedPreferences pref;

    public TokenRepository(Context context) {
        this.context = context;
        this.pref = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        pref.edit().putString(AUTH_TOKEN, token).apply();
    }

    public String getToken() {
        return pref.getString(AUTH_TOKEN, "");
    }
}
