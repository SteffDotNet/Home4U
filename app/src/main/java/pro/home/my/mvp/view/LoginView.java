package pro.home.my.mvp.view;

/**
 * Created by egor.stepanov on 22.02.2018.
 */

public interface LoginView extends NetworkView {
    void showProgressDialog();
    
    void hideProgressDialog();
}
