package pro.home.my.ui.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import pro.home.my.R;
import pro.home.my.di.model.DeviceEvent;
import pro.home.my.ui.recycler.holder.DeviceEventHolder;

public class DeviceEventAdapter extends RecyclerView.Adapter<DeviceEventHolder> {
    private List<DeviceEvent> events;
    private int selectedPosition = -1;

    public DeviceEventAdapter() {
        events = new ArrayList<>();
        events.add(new DeviceEvent("Event 1"));
        events.add(new DeviceEvent("Event 2"));
        events.add(new DeviceEvent("Event 3"));
    }

    @Override
    public DeviceEventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ((LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_event, parent, false);
        DeviceEventHolder holder = new DeviceEventHolder(view);
        holder.itemView.setOnClickListener(v -> {
            selectedPosition = holder.getAdapterPosition();
            notifyDataSetChanged();
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(DeviceEventHolder holder, int position) {
        holder.titleTextView.setText(getEvent(position).getName());
        holder.checkImageView.setVisibility(selectedPosition == position ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    private DeviceEvent getEvent(int position){
        return events.get(position);
    }

    public void setEvents(List<DeviceEvent> events){
        this.events = events;
        notifyDataSetChanged();
    }

}
