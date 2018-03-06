package pro.home.my.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pro.home.my.api.AuthApi;
import retrofit2.Retrofit;

@Module(includes = RetrofitModule.class)
public class ApiModule {

    @Provides
    @Singleton
    public AuthApi provideLoginApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }
}
