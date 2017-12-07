package com.example.jlwj.picker;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    DateTimePicker picker;

    Calendar calendar;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        picker = (DateTimePicker) findViewById(R.id.picker);

        Date date = new Date();
        calendar = Calendar.getInstance();
        calendar.setTime(date);

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        int curHour = calendar.get(Calendar.HOUR_OF_DAY);
        int curMinute = calendar.get(Calendar.MINUTE);

        calendar.set(curYear, curMonth, curDay, curHour, curMinute);
        String curTime = format.format(calendar.getTime());

        textView.setText(curTime);

        picker.setOnDateTimeChangedListener(new OnDateTimeChangeListener() {
            @Override
            public void onDateTimeChange(DateTimePicker view, int year, int monthOfYear, int dayOfMonth, int hour, int minute) {
                //calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth, hour, minute);
                String curTime = format.format(calendar.getTime());

                textView.setText(curTime);

            }
        });
    }
}
