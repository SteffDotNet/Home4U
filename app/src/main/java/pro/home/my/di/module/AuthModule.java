package pro.home.my.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pro.home.my.api.AuthApi;
import pro.home.my.mvp.model.AuthService;

@Module(includes = ApiModule.class)
public class AuthModule {

    @Provides
    @Singleton
    public AuthService provideLoginService(AuthApi authApi){
        return new AuthService(authApi);
    }
}
