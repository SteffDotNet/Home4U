package pro.home.my.di;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import pro.home.my.di.module.ApiModule;
import pro.home.my.di.module.ContextModule;

/**
 * Created by egor.stepanov on 22.02.2018.
 */

@Singleton
@Component(modules = {ContextModule.class})
public interface AppComponent {
    Context getContext();
}
