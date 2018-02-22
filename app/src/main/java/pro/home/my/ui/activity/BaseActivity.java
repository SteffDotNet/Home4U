package pro.home.my.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Egor on 21.02.2018.
 */

public class BaseActivity extends AppCompatActivity {
    private CompositeDisposable compositeDisposable;

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeDisposable = new CompositeDisposable();
    }

    protected void add(Disposable disposable){
        if(compositeDisposable != null){
            compositeDisposable.add(disposable);
        }
    }

    protected void dispose(){
        if(compositeDisposable != null){
            compositeDisposable.dispose();
        }
    }
}
