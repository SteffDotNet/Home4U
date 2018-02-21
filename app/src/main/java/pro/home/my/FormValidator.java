package pro.home.my;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import java.util.regex.Pattern;


public class FormValidator {
    private static final int MIN_LENGT_PSW = 5;
    private static final int MAX_LENGT_PSW = 20;

    private static final String REGEX_LOGIN = "^[a-zA-Z0-9_]{3,16}$";
    private static final String REGEX_NAME = "^[a-zA-Zа-яА-Я]{2,16}$";

    public static boolean isEmailValid(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password){
        return !TextUtils.isEmpty(password) && (password.length() > MIN_LENGT_PSW && password.length() < MAX_LENGT_PSW);
    }

    public static boolean isLoginValid(String login){
        return !TextUtils.isEmpty(login) && Pattern.compile(REGEX_LOGIN).matcher(login).matches();
    }

    public static boolean isNameValid(String name){
        return TextUtils.isEmpty(name) || Pattern.compile(REGEX_NAME).matcher(name).matches();
    }

    public static boolean isPhoneValid(String phone){
        return TextUtils.isEmpty(phone) || Patterns.PHONE.matcher(phone).matches();
    }

    public static boolean isConfirmPassword(String psw1, String psw2){
        return TextUtils.equals(psw1, psw2);
    }
}
