package pro.home.my.mvp.model;

import io.reactivex.Observable;
import pro.home.my.api.AuthApi;
import pro.home.my.di.model.ServerResponse;
import pro.home.my.di.model.User;

public class AuthService {

    private AuthApi authApi;

    public AuthService(AuthApi authApi) {
        this.authApi = authApi;
    }

    public Observable<ServerResponse> login(String login, String password){
        return authApi.loginUser(login, password);
    }

    public Observable<ServerResponse> register(String email, String login, String password, String surname, String name, String phoneNumber){
        return authApi.registerUser(email, login, password, surname, name, phoneNumber);
    }
    

}
