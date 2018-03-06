package pro.home.my.mvp.presenter;

import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pro.home.my.app.HomeApp;
import pro.home.my.mvp.model.LoginService;
import pro.home.my.mvp.view.LoginView;


@InjectViewState
public class LoginPresenter extends BasePresenter<LoginView> {

    @Inject
    LoginService loginService;

    public LoginPresenter() {
        HomeApp.getAppComponent().inject(this);
    }

    public void login(String login, String password) {
        getViewState().showProgressDialog();
        loginService.login(login, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(res -> {
                    getViewState().hideProgressDialog();
                    if(res.getStatus().equals("ok")){
                        //redirect to main
                    }else{
                        Toast.makeText(HomeApp.getAppComponent().getContext(), res.getError(), Toast.LENGTH_SHORT).show();
                    }
                }, error -> {
                    getViewState().hideProgressDialog();
                });
    }
}
