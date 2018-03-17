package pro.home.my.ui.recycler.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pro.home.my.R;

public class DeviceHolder extends RecyclerView.ViewHolder {
    public TextView nameTextView;
    public TextView stateTextView;

    public DeviceHolder(View itemView) {
        super(itemView);
        nameTextView = (TextView)itemView.findViewById(R.id.nameTextView);
        stateTextView = (TextView)itemView.findViewById(R.id.stateTextView);
    }
}
