package pro.home.my.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface NetworkView extends MvpView {

    void showMessage(int messageResId);

    void showProgressDialog();

    void hideProgressDialog();
}
