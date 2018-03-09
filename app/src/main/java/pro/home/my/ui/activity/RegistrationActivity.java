package pro.home.my.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import pro.home.my.di.model.User;
import pro.home.my.mvp.presenter.RegistrationPresenter;
import pro.home.my.mvp.view.RegistrationView;
import pro.home.my.ui.dialog.ProgressDialog;
import pro.home.my.utils.FormValidator;
import pro.home.my.R;

public class RegistrationActivity extends BaseActivity implements RegistrationView{

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
    Button signUpButton;
    @BindView(R.id.emailErrorView)
    TextView emailErrorView;
    @BindView(R.id.loginErrorView)
    TextView loginErrorView;
    @BindView(R.id.passwordErrorView)
    TextView passwordErrorView;
    @BindView(R.id.confirmErrorView)
    TextView confirmErrorView;

    @InjectPresenter
    RegistrationPresenter presenter;
    private ProgressDialog dialog;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        dialog = new ProgressDialog(this);

        Observable<Boolean> o1 = RxTextView.textChanges(emailEditText)
                .map(CharSequence::toString)
                .map(TextUtils::isEmpty);
        Observable<Boolean> o2 = RxTextView.textChanges(loginEditText)
                .map(CharSequence::toString)
                .map(TextUtils::isEmpty);
        Observable<Boolean> o3 = RxTextView.textChanges(passwordEditText)
                .map(CharSequence::toString)
                .map(TextUtils::isEmpty);
        Observable<Boolean> o4 = RxTextView.textChanges(passwordConfirmEditText)
                .map(CharSequence::toString)
                .map(TextUtils::isEmpty);

        add(Observable.combineLatest(o1, o2, o3, o4, this::isEmptyFields)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    signUpButton.setEnabled(!res);
                    signUpButton.setBackgroundResource(res ? R.drawable.button_auth_inactive : R.drawable.button_auth_active);
                })
        );


        signUpButton.setOnClickListener(view -> {
            if(isRegistrationValid()){
                Log.d("TAG", "signUp ok");
                String email = emailEditText.getText().toString().trim();
                String login = loginEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();
                String surname = surnameEditText.getText().toString().trim();
                String name = nameEditText.getText().toString().trim();
                String phoneNumber = phoneEditText.getText().toString().trim();
                presenter.register(email, login, password, surname, name, phoneNumber);
            }
        });
    }

    private boolean isRegistrationValid(){
        boolean v1 = FormValidator.isEmailValid(emailEditText.getText().toString().trim());
        boolean v2 = FormValidator.isLoginValid(loginEditText.getText().toString().trim());
        boolean v3 = FormValidator.isPasswordValid(passwordEditText.getText().toString());
        boolean v4 = FormValidator.isPasswordValid(passwordConfirmEditText.getText().toString());
        boolean isPswMatch = FormValidator.isPasswordEquals(passwordEditText.getText().toString(), passwordConfirmEditText.getText().toString());

        emailErrorView.setVisibility(v1 ? View.INVISIBLE : View.VISIBLE);
        loginErrorView.setVisibility(v2 ? View.INVISIBLE : View.VISIBLE);
        passwordErrorView.setText(R.string.error_invalid_password);
        passwordErrorView.setVisibility(v3 ? View.INVISIBLE : View.VISIBLE);
        confirmErrorView.setText(R.string.error_invalid_password);
        confirmErrorView.setVisibility(v4 ? View.INVISIBLE : View.VISIBLE);

        if(v3 && v4){
            passwordErrorView.setText(R.string.error_no_match_passwords);
            confirmErrorView.setText(R.string.error_no_match_passwords);
            passwordErrorView.setVisibility(isPswMatch ? View.INVISIBLE : View.VISIBLE);
            confirmErrorView.setVisibility(isPswMatch ? View.INVISIBLE : View.VISIBLE);
        }

        return v1 && v2 && v3 && v4 && isPswMatch;
    }

    private boolean isEmptyFields(boolean v1, boolean v2, boolean v3, boolean v4){
        return v1 || v2 || v3 || v4;
    }

    @Override
    public void showProgressDialog() {
        if(dialog != null){
            dialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if(dialog != null){
            dialog.hide();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispose();
    }
}

