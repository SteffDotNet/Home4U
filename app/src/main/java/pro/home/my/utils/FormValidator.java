package pro.home.my.utils;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Pattern;

public class FormValidator {
    private static final int MIN_LENGTH_PSW = 6;
    private static final int MAX_LENGTH_PSW = 20;

    private static final String REGEX_LOGIN = "^[a-zA-Z0-9_]{3,16}$";
    private static final String REGEX_NAME = "^[a-zA-Zа-яА-Я]{2,16}$";

    public static boolean isEmailValid(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password){
        return (password.length() >= MIN_LENGTH_PSW && password.length() <= MAX_LENGTH_PSW);
    }

    public static boolean isPasswordEquals(String psw1, String psw2){
        return TextUtils.equals(psw1, psw2);
    }

    public static boolean isLoginValid(String login){
        return Pattern.compile(REGEX_LOGIN).matcher(login).matches();
    }

    public static boolean isNameValid(String name){
        return Pattern.compile(REGEX_NAME).matcher(name).matches();
    }

    public static boolean isPhoneValid(String phone){
        return Patterns.PHONE.matcher(phone).matches();
    }

    public static boolean isConfirmPassword(String psw1, String psw2){
        return TextUtils.equals(psw1, psw2);
    }
}
