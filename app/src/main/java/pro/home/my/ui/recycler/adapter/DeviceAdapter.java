package pro.home.my.ui.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pro.home.my.R;
import pro.home.my.di.model.Device;
import pro.home.my.di.model.DeviceEvent;
import pro.home.my.ui.recycler.holder.DeviceEventHolder;
import pro.home.my.ui.recycler.holder.DeviceHolder;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceHolder> {
    private List<Device> devices;
    private int selectedPosition = -1;

    public DeviceAdapter() {
        devices = new ArrayList<>();
        devices.add(new Device(1, "Device 1", "On"));
        devices.add(new Device(2, "Device 2", "Off"));
        devices.add(new Device(3, "Device 3", "On"));
        devices.add(new Device(4, "Device 4", "Off"));
        devices.add(new Device(5, "Device 5", "Off"));
    }

    @Override
    public DeviceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ((LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_device, parent, false);
        DeviceHolder holder = new DeviceHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DeviceHolder holder, int position) {
        holder.nameTextView.setText(getDevice(position).getName());
        holder.stateTextView.setText(getDevice(position).getState());
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    private Device getDevice(int position){
        return devices.get(position);
    }

    public void setDevices(List<Device> devices){
        this.devices = devices;
        notifyDataSetChanged();
    }

}
