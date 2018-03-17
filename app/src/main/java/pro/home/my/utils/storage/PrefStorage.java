package pro.home.my.utils.storage;


import android.content.Context;
import android.content.SharedPreferences;

import pro.home.my.app.HomeApp;

public class PrefStorage {
    private static final String prefName = "Home_pref";

    public static SharedPreferences getPreference() {
        return HomeApp.getAppComponent().getContext().getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor() {
        return HomeApp.getAppComponent().getContext().getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
    }
}
