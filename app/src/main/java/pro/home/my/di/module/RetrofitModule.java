package pro.home.my.di.module;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import pro.home.my.utils.Settings;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by egor.stepanov on 22.02.2018.
 */

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Settings.BASE_URL + Settings.API_VERSION + "/")
                .build();
    }
}
