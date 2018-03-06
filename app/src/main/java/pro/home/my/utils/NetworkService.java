package pro.home.my.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import pro.home.my.app.HomeApp;
import pro.home.my.di.AppComponent;

public class NetworkService {
    public static boolean isConnection(){
        ConnectivityManager cm = (ConnectivityManager)HomeApp.getAppComponent().getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
