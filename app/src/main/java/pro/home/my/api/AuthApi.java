package pro.home.my.api;


import io.reactivex.Observable;
import pro.home.my.di.model.ServerResponse;
import pro.home.my.di.model.User;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthApi {

    @POST("login.php")
    Observable<ServerResponse> loginUser(@Query("login") String login, @Query("password") String password);

    @POST("register.php")
    Observable<ServerResponse> registerUser(@Query("email") String email, @Query("login") String login, @Query("password") String password, @Query("surname") String surname, @Query("name") String name, @Query("phone") String phoneNumber);
}
