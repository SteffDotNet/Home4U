package pro.home.my.api;


import io.reactivex.Observable;
import pro.home.my.di.model.User;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("login") Observable<User> loginUser(@Body User user);

    @POST("registration") Observable<User> registerUser(@Body User user);
}
