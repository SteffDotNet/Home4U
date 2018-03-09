package pro.home.my.mvp.presenter;

import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pro.home.my.app.HomeApp;
import pro.home.my.di.model.User;
import pro.home.my.mvp.model.AuthService;
import pro.home.my.mvp.view.LoginView;
import pro.home.my.mvp.view.RegistrationView;


@InjectViewState
public class RegistrationPresenter extends BasePresenter<RegistrationView> {

    @Inject
    AuthService authService;

    public RegistrationPresenter() {
        HomeApp.getAppComponent().inject(this);
    }

    public void register(String email, String login, String password, String surname, String name, String phoneNumber) {
        getViewState().showProgressDialog();
        authService.register(email, login, password, surname, name, phoneNumber)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(res -> {
                    getViewState().hideProgressDialog();
                    if(res.getStatus().equals("ok")){
                        //redirect to main
                        Toast.makeText(HomeApp.getAppComponent().getContext(), "Ok", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(HomeApp.getAppComponent().getContext(), res.getError(), Toast.LENGTH_SHORT).show();
                    }
                }, error -> {
                    getViewState().hideProgressDialog();
                });
    }

}
