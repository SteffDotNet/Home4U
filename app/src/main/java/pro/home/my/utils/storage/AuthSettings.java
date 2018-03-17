package pro.home.my.utils.storage;

import android.text.TextUtils;

import com.google.gson.Gson;

import pro.home.my.di.model.User;

public class AuthSettings {
    public final static String USER_DETAILS = "user_details";

    public static User getUser(){
        String userJson = PrefStorage.getPreference().getString(USER_DETAILS, "");
        return TextUtils.isEmpty(userJson) ? null : new Gson().fromJson(userJson, User.class);
    }

    public static void setUser(User user){
        PrefStorage.getEditor().putString(USER_DETAILS, new Gson().toJson(user));
    }
}
