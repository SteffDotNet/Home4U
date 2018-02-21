package pro.home.my.utils.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pro.home.my.FormValidator;
import pro.home.my.R;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginEditText)
    EditText emailEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.registrationTextView)
    TextView registrationTextView;
    @BindView(R.id.signButton)
    Button signButton;

    private boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Observable<Boolean> o1 = RxTextView.textChanges(emailEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isEmailValid);

        Observable<Boolean> o2 = RxTextView.textChanges(passwordEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isPasswordValid);


        Observable.combineLatest(o1, o2, this::checkInput)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(res -> {
                    isValid = res;
                });

        signButton.setOnClickListener(v -> {
            if(!isValid){
                Toast.makeText(this, R.string.error_invalid_sign, Toast.LENGTH_SHORT).show();
                return;
            }
        });

        registrationTextView.setOnClickListener(v -> {startActivity(new Intent(this, RegistrationActivity.class));});
    }

    private boolean checkInput(boolean isEmail, boolean isPassword){
        return isEmail && isPassword;
    }

}

