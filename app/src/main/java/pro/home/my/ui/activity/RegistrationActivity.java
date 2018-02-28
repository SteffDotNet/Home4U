package pro.home.my.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import pro.home.my.utils.FormValidator;
import pro.home.my.R;

public class RegistrationActivity extends BaseActivity{

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
    @BindView(R.id.emailTextInput)
    TextInputLayout emailTextInputLayout;
    @BindView(R.id.loginTextInput)
    TextInputLayout loginTextInputLayout;
    @BindView(R.id.passwordTextInput)
    TextInputLayout passwordTextInputLayout;
    @BindView(R.id.confirmTextInput)
    TextInputLayout confirmTextInputLayout;
    @BindView(R.id.nameTextInput)
    TextInputLayout nameTextInputLayout;
    @BindView(R.id.surnameTextInput)
    TextInputLayout surnameTextInputLayout;
    @BindView(R.id.phoneTextInput)
    TextInputLayout phoneTextInputLayout;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        RxTextView.textChanges(emailEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isEmailValid)
                .subscribe(res -> {
                    emailTextInputLayout.setError(res ? "" : getString(R.string.error_incorrect_email));
                    emailTextInputLayout.setErrorEnabled(!res);
                });

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

        Observable<Boolean> o5 = RxTextView.textChanges(nameEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isNameValid);

        Observable<Boolean> o6 = RxTextView.textChanges(surnameEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isNameValid);

        Observable<Boolean> o7 = RxTextView.textChanges(phoneEditText)
                .map(CharSequence::toString)
                .map(FormValidator::isPhoneValid);

        add(Observable.combineLatest(o1, o2, o3, o4, o5, o6, o7, this::isRegistrationValid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {

                }));

        registerButton.setOnClickListener(view -> {
        });
    }

    private boolean isRegistrationValid(boolean v1, boolean v2, boolean v3, boolean v4, boolean v5, boolean v6, boolean v7){

        loginTextInputLayout.setError(v2 ? "" : getString(R.string.error_incorrect_login));
        loginTextInputLayout.setErrorEnabled(!v2);
        passwordTextInputLayout.setError(v3 ? "" : getString(R.string.error_length_password));
        passwordTextInputLayout.setErrorEnabled(!v3);
        confirmTextInputLayout.setError(v4 ? "" : getString(R.string.error_length_password));
        confirmTextInputLayout.setErrorEnabled(!v4);
        nameTextInputLayout.setError(v5 ? "" : getString(R.string.error_incorrect_name));
        nameTextInputLayout.setErrorEnabled(!v5);
        surnameTextInputLayout.setError(v6 ? "" : getString(R.string.error_incorrect_surname));
        surnameTextInputLayout.setErrorEnabled(!v6);
        phoneTextInputLayout.setError(v7 ? "" : getString(R.string.error_incorrect_phone));
        phoneTextInputLayout.setErrorEnabled(!v7);

        boolean isEquals = FormValidator.isPasswordEquals(passwordEditText.getText().toString().trim(), passwordConfirmEditText.getText().toString().trim());


        return v1 && v2 && v3 && v4 && v5 && v6 && v7;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispose();
    }
}

