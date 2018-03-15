package pro.home.my.ui.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.sapereaude.maskedEditText.MaskedEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import pro.home.my.R;
import pro.home.my.mvp.view.AddView;
import pro.home.my.ui.dialog.DeviceDataDialog;
import pro.home.my.ui.dialog.DeviceEventDialog;

public class AddActivity extends BaseActivity implements AddView {
    @BindView(R.id.dateTextView)
    MaskedEditText dateEditText;
    @BindView(R.id.timeTextView)
    MaskedEditText timeEditText;
    @BindView(R.id.dateImageView)
    ImageView dateImageView;
    @BindView(R.id.timeImageView)
    ImageView timeImageView;

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        dateImageView.setOnClickListener(v -> showDatePicker());
        timeImageView.setOnClickListener(v -> showTimePicker());


        calendar = Calendar.getInstance();
        updateDateTime();
    }

    private void updateDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        dateEditText.setText(dateFormat.format(calendar.getTime()));
        timeEditText.setText(timeFormat.format(calendar.getTime()));
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            updateDateTime();
        }
    };

    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            updateDateTime();
        }
    };


    @Override
    public void showDatePicker() {
        new DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    @Override
    public void showTimePicker() {
        new TimePickerDialog(
                this,
                timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true)
                .show();
    }

    @Override
    public void showEventDialog() {
        DeviceEventDialog.show(this);
    }

    @Override
    public void showDataDialog() {
        DeviceDataDialog.show(this);
    }

}
