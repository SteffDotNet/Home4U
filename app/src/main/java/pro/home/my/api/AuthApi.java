package pro.home.my.api;


import io.reactivex.Observable;
import pro.home.my.di.model.SearchResult;
import pro.home.my.di.model.ServerResponse;
import pro.home.my.di.model.User;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthApi {

    @POST("login.php") Observable<ServerResponse> loginUser(@Query("login") String login, @Query("password") String password);

    @POST("register.php") Observable<User> registerUser(@Body User user);
}
