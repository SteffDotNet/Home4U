package pro.home.my.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import pro.home.my.mvp.view.NetworkView;


public class BaseActivity extends MvpAppCompatActivity implements NetworkView {
    private CompositeDisposable compositeDisposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeDisposable = new CompositeDisposable();
    }

    protected void addDisposable(Disposable disposable){
        if(compositeDisposable != null){
            compositeDisposable.add(disposable);
        }
    }

    protected void dispose(){
        if(compositeDisposable != null){
            compositeDisposable.dispose();
        }
    }

    @Override
    public void showMessage(int messageResId) {
        Toast.makeText(this, getString(messageResId), Toast.LENGTH_SHORT).show();
    }
}
