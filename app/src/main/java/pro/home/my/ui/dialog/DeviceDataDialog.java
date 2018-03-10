package pro.home.my.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import pro.home.my.R;
import pro.home.my.ui.recycler.adapter.DeviceEventAdapter;

/**
 * Created by Egor on 09.03.2018.
 */

public class DeviceDataDialog {

    public static void show(Context context){
        View view = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_data, null);
        AlertDialog alertDialog = new AlertDialog.Builder(context).setView(view).create();
        alertDialog.show();
    }
}
