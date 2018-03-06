package pro.home.my.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.home.my.R;
import pro.home.my.mvp.presenter.LoginPresenter;
import pro.home.my.mvp.view.LoginView;
import pro.home.my.ui.dialog.ProgressDialog;
import pro.home.my.utils.NetworkService;

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.loginEditText)
    EditText loginEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.sign_upTextView)
    TextView sign_upTextView;
    @BindView(R.id.signButton)
    Button signButton;

    @InjectPresenter LoginPresenter loginPresenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        dialog = new ProgressDialog(this);

        signButton.setOnClickListener(v -> {
            if(!NetworkService.isConnection()){
                showMessage(R.string.no_internet_connection);
                return;
            }
            loginPresenter.login(loginEditText.getText().toString(), passwordEditText.getText().toString().trim());
        });

        sign_upTextView.setOnClickListener(v -> startActivity(new Intent(this, RegistrationActivity.class)));
    }

    public void updateUI(){
        int mode = 1;
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
}

