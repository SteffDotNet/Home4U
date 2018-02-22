package pro.home.my.mvp.view;

import com.arellomobile.mvp.MvpView;

/**
 * Created by egor.stepanov on 22.02.2018.
 */

public interface NetworkView extends MvpView {

    void showMessage(int messageResId);

    void showDialog(int messageResId);
}
