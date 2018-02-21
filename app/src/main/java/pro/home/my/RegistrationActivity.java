package pro.home.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.loginEditText)
    EditText loginEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.passwordConfirmEditText)
    EditText passwordConfirmEditText;
    @BindView(R.id.nameEditText)
    EditText nameEditText;
    @BindView(R.id.surnameEditText)
    EditText surnameEditText;
    @BindView(R.id.phoneEditText)
    EditText phoneEditText;
    @BindView(R.id.registerButton)
    Button registerButton;
    @BindView(R.id.errorEmailTextView)
    TextView errorEmailTextView;
    @BindView(R.id.errorLoginTextView)
    TextView errorLoginTextView;
    @BindView(R.id.errorPsw1TextView)
    TextView errorPsw1TextView;
    @BindView(R.id.errorPsw2TextView)
    TextView errorPsw2TextView;
    @BindView(R.id.errorNameTextView)
    TextView errorNameTextView;
    @BindView(R.id.errorSurnameTextView)
    TextView errorSurnameTextView;
    @BindView(R.id.errorPhoneTextView)
    TextView errorPhoneTextView;

    private Observable<Boolean> o1;
    private Observable<Boolean> o2;
    private Observable<Boolean> o3;
    private Observable<Boolean> o4;
    private Observable<Boolean> o5;
    private Observable<Boolean> o6;
    private Observable<Boolean> o7;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        o1 = RxTextView.textChanges(emailEditText)
                .map(CharSequence::toString)
                .map(this::checkEmail);

        o2 = RxTextView.textChanges(loginEditText)
                .map(CharSequence::toString)
                .map(this::checkLogin);

        o3 = RxTextView.textChanges(passwordEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isPasswordValid);

        o4 = RxTextView.textChanges(passwordConfirmEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isPasswordValid);

        o5 = RxTextView.textChanges(nameEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isNameValid);

        o6 = RxTextView.textChanges(surnameEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isNameValid);

        o7 = RxTextView.textChanges(phoneEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isPhoneValid);
        registerButton.setOnClickListener(this);

        Observable.combineLatest(o1, o2, o3, o4, o5, o6, o7, this::isRegistrationValid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {

                });
    }

    private boolean checkEmail(String email){
        if(FormValidator.isEmailValid(email)){
            errorEmailTextView.setVisibility(View.GONE);
            return true;
        }
        errorEmailTextView.setVisibility(View.VISIBLE);
        return false;
    }

    private boolean checkLogin(String login){
        if(FormValidator.isLoginValid(login)){
            errorLoginTextView.setVisibility(View.GONE);
            return true;
        }
        errorLoginTextView.setVisibility(View.VISIBLE);
        return false;
    }

    private boolean isRegistrationValid(boolean v1, boolean v2, boolean v3, boolean v4, boolean v5, boolean v6, boolean v7){

        errorPsw1TextView.setVisibility(v3 ? View.GONE : View.VISIBLE);
        errorPsw2TextView.setVisibility(v4 ? View.GONE : View.VISIBLE);
        errorNameTextView.setVisibility(v5 ? View.GONE : View.VISIBLE);
        errorSurnameTextView.setVisibility(v6 ? View.GONE : View.VISIBLE);
        errorPhoneTextView.setVisibility(v7 ? View.GONE : View.VISIBLE);
        return v1 && v2 && v3 && v4 && v5 && v6 && v7;
    }

    @Override public void onClick(View view) {

    }
}

