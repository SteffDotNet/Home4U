package pro.home.my.mvp.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by egor.stepanov on 22.02.2018.
 */

public class BasePresenter <V extends MvpView> extends MvpPresenter<V> {
    private CompositeDisposable compositeDisposable;

    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override public void onDestroy() {
        super.onDestroy();
        dispose();
    }

    protected void addDisposable(Disposable disposable){
        if(compositeDisposable != null){
            compositeDisposable.add(disposable);
        }
    }

    private void dispose(){
        if(compositeDisposable != null){
            compositeDisposable.dispose();
        }
    }
}
