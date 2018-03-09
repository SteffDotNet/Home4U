package pro.home.my.di;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;

import pro.home.my.di.module.ContextModule;
import pro.home.my.di.module.AuthModule;
import pro.home.my.mvp.presenter.LoginPresenter;
import pro.home.my.mvp.presenter.RegistrationPresenter;

@Singleton
@Component(modules = {ContextModule.class, AuthModule.class})
public interface AppComponent {
    Context getContext();

    void inject(LoginPresenter loginPresenter);

    void inject(RegistrationPresenter registrationPresenter);
}
