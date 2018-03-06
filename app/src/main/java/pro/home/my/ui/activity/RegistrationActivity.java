package pro.home.my.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import pro.home.my.di.model.User;
import pro.home.my.utils.FormValidator;
import pro.home.my.R;

public class RegistrationActivity extends BaseActivity{

    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.loginEditText)
    EditText loginEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.confirmEditText)
    EditText passwordConfirmEditText;
    @BindView(R.id.nameEditText)
    EditText nameEditText;
    @BindView(R.id.surnameEditText)
    EditText surnameEditText;
    @BindView(R.id.phoneEditText)
    EditText phoneEditText;
    @BindView(R.id.registerButton)
    Button registerButton;
    @BindView(R.id.emailErrorView)
    TextView emailErrorView;
    @BindView(R.id.loginErrorView)
    TextView loginErrorView;
    @BindView(R.id.passwordErrorView)
    TextView passwordErrorView;
    @BindView(R.id.confirmErrorView)
    TextView confirmErrorView;

    private boolean isValid = false;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);


        Observable<Boolean> o1 = RxTextView.textChanges(emailEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isEmailValid);

        Observable<Boolean> o2 = RxTextView.textChanges(loginEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isLoginValid);

        Observable<Boolean> o3 = RxTextView.textChanges(passwordEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isPasswordValid);

        Observable<Boolean> o4 = RxTextView.textChanges(passwordConfirmEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isPasswordValid);

        add(Observable.combineLatest(o1, o2, o3, o4, this::isRegistrationValid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                   isValid = res;
                })
        );


        registerButton.setOnClickListener(view -> {
            if(isValid){
                Log.i("TAG", "Register");
            }
        });
    }

    private boolean isRegistrationValid(boolean v1, boolean v2, boolean v3, boolean v4){
        boolean isPswMatch = FormValidator.isPasswordEquals(passwordEditText.getText().toString().trim(), passwordConfirmEditText.getText().toString().trim());

        if(!isEmptyField(emailEditText)){
            emailErrorView.setVisibility(v1 ? View.INVISIBLE : View.VISIBLE);
        }
        if(!isEmptyField(loginEditText)){
            loginErrorView.setVisibility(v2 ? View.INVISIBLE : View.VISIBLE);
        }
        if(!isEmptyField(passwordEditText)){
            passwordErrorView.setText(R.string.error_invalid_password);
            passwordErrorView.setVisibility(v3 ? View.INVISIBLE : View.VISIBLE);
        }
        if(!isEmptyField(passwordConfirmEditText)){
            confirmErrorView.setText(R.string.error_invalid_password);
            confirmErrorView.setVisibility(v4 ? View.INVISIBLE : View.VISIBLE);
        }

        if(!isEmptyField(passwordConfirmEditText) && !isEmptyField(passwordConfirmEditText) && v3 && v4){
            passwordErrorView.setText(R.string.error_no_match_passwords);
            confirmErrorView.setText(R.string.error_no_match_passwords);
            passwordErrorView.setVisibility(isPswMatch ? View.INVISIBLE : View.VISIBLE);
            confirmErrorView.setVisibility(isPswMatch ? View.INVISIBLE : View.VISIBLE);
        }

        return v1 && v2 && v3 && v4 && isPswMatch;
    }

    private boolean isEmptyField(EditText editText){
        return TextUtils.isEmpty(editText.getText().toString());
    }

   /* private boolean isEmptyFields(){
        emailErrorView.setVisibility(v1 ? View.INVISIBLE : View.VISIBLE);
    }*/


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispose();
    }
}

