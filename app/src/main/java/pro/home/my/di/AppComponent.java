package pro.home.my.di;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import pro.home.my.di.module.ApiModule;
import pro.home.my.di.module.ContextModule;
import pro.home.my.di.module.LoginModule;
import pro.home.my.mvp.presenter.LoginPresenter;

@Singleton
@Component(modules = {ContextModule.class, LoginModule.class})
public interface AppComponent {
    Context getContext();

    void inject(LoginPresenter loginPresenter);
}
