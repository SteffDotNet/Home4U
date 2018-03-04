package pro.home.my.app;

import android.app.Application;
import pro.home.my.di.AppComponent;
import pro.home.my.di.DaggerAppComponent;
import pro.home.my.di.module.ContextModule;

/**
 * Created by egor.stepanov on 22.02.2018.
 */

public class HomeApp extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger(){
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }
}
