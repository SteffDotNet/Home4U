package pro.home.my.ui.recycler.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pro.home.my.R;

public class DeviceEventHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public ImageView checkImageView;

    public DeviceEventHolder(View itemView) {
        super(itemView);
        titleTextView = (TextView)itemView.findViewById(R.id.titleTextView);
        checkImageView = (ImageView)itemView.findViewById(R.id.checkImageView);
    }
}
