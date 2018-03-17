package pro.home.my.ui.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pro.home.my.R;
import pro.home.my.di.model.Room;
import pro.home.my.ui.recycler.holder.RoomHolder;

public class RoomAdapter extends RecyclerView.Adapter<RoomHolder> {
    private List<Room> rooms;
    private int selectedPosition = -1;

    public RoomAdapter() {
        rooms = new ArrayList<>();
        rooms.add(new Room(1, "Room 1"));
        rooms.add(new Room(2, "Room 2"));
        rooms.add(new Room(3, "Room 3"));
    }

    @Override
    public RoomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ((LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_room, parent, false);
        RoomHolder holder = new RoomHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RoomHolder holder, int position) {
        holder.nameTextView.setText(getDevice(position).getName());
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    private Room getDevice(int position) {
        return rooms.get(position);
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
        notifyDataSetChanged();
    }

}
