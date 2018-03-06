package pro.home.my.di.service;

import android.content.Context;
import android.content.SharedPreferences;

import pro.home.my.app.HomeApp;
import pro.home.my.utils.Settings;

public class StorageService {
    private static final String APP_MODE = "APP_MODE";
    private SharedPreferences sharedPreferences;

    public StorageService() {
        sharedPreferences = HomeApp.getAppComponent().getContext().getSharedPreferences(Settings.STORAGE_NAME, Context.MODE_PRIVATE);
    }



    public void saveValue(String key, String value){
        if(sharedPreferences != null){
            sharedPreferences.edit().putString(key, value).commit();
        }
    }

    public void saveValue(String key, int value){
        if(sharedPreferences != null){
            sharedPreferences.edit().putInt(key, value).commit();
        }
    }

    public String getStringValue(String key, String default_value){
        if(sharedPreferences != null){
            return sharedPreferences.getString(key, default_value);
        }else {
            return default_value;
        }
    }

    public int getIntValue(String key, int default_value){
        if(sharedPreferences != null){
            return sharedPreferences.getInt(key, default_value);
        }else {
            return default_value;
        }
    }

    public void saveMode(int mode){
        saveValue(APP_MODE, mode);
    }

    public int getMode(){
        return getIntValue(APP_MODE, 1);
    }
}
