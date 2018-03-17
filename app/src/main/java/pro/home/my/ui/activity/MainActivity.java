package pro.home.my.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.home.my.R;
import pro.home.my.mvp.presenter.MainPresenter;
import pro.home.my.mvp.view.MainView;
import pro.home.my.ui.recycler.adapter.DeviceAdapter;
import pro.home.my.ui.recycler.adapter.RoomAdapter;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.deviceRecycleView)
    RecyclerView deviceRecyclerView;
    @BindView(R.id.roomRecycleView)
    RecyclerView roomRecyclerView;

    private DeviceAdapter deviceAdapter;
    private RoomAdapter roomAdapter;
    private SnapHelper snapHelperDevice;
    private SnapHelper snapHelperRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        deviceRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        roomRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        snapHelperDevice = new GravitySnapHelper(Gravity.START, false);
        snapHelperRoom = new GravitySnapHelper(Gravity.START, false);
        snapHelperDevice.attachToRecyclerView(deviceRecyclerView);
        snapHelperRoom.attachToRecyclerView(roomRecyclerView);
        deviceAdapter = new DeviceAdapter();
        roomAdapter = new RoomAdapter();
        deviceRecyclerView.setAdapter(deviceAdapter);
        roomRecyclerView.setAdapter(roomAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.add_data:
                startActivity(new Intent(this, AddActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMessage(int messageResId) {

    }
}
