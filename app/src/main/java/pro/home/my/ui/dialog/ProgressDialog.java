package pro.home.my.ui.dialog;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import pro.home.my.R;

public class ProgressDialog {

    private AlertDialog alertDialog;
    private TextView messageTextView;

    public ProgressDialog(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_progress, null);
        messageTextView = (TextView) view.findViewById(R.id.messageTextView);
        alertDialog = new AlertDialog.Builder(context).setView(view).create();
    }

    public void show(){
        alertDialog.show();
    }

    public void hide(){
        alertDialog.dismiss();
    }

    public void setMessage(String message){
        messageTextView.setText(message);
    }

    public void setMessage(int messageResId){
        messageTextView.setText(messageResId);
    }

    public boolean isShow(){
        return alertDialog.isShowing();
    }
}
