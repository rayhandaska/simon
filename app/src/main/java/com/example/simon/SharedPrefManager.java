package com.example.simon;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefManager {

    private static SharedPrefManager instance;
    private static Context ctx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NOMOR_TELP = "nomor_telp";

    private SharedPrefManager(Context context) {
        ctx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefManager(context);
        }
        return instance;
    }

    public boolean userLogin(int id, String username, String email, String name, String nomor_telp){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, id);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_NOMOR_TELP, nomor_telp);


        editor.apply();

        return true;
    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME, null) != null){
            return true;
        }
        return false;
    }
    public String getUsername(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null);
    }
    public String getUserEmail(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EMAIL, null);
    }
    public String getNamaLengkap(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NAME, null);
    }
    public String getNomorTelp(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NOMOR_TELP, null);
    }


}