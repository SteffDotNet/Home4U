package pro.home.my.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
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

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.deviceRecycleView)
    RecyclerView recyclerView;

    private DeviceAdapter adapter;
    private SnapHelper snapHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        snapHelper = new GravitySnapHelper(Gravity.START, false, position -> {

        });
        snapHelper.attachToRecyclerView(recyclerView);
        adapter = new DeviceAdapter();
        recyclerView.setAdapter(adapter);


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
