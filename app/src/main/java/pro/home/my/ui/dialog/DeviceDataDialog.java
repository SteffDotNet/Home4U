package pro.home.my.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import pro.home.my.R;

public class DeviceDataDialog {

    public static void show(Context context){
        View view = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_data, null);
        AlertDialog alertDialog = new AlertDialog.Builder(context).setView(view).create();
        alertDialog.show();
    }
}
