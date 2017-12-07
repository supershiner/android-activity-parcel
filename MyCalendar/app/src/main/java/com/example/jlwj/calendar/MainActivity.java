package com.example.jlwj.calendar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView monthText;
    TextView tmpTextView = null;
    GridView monthView;
    MonthAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthText = (TextView) findViewById(R.id.monthText);
        monthView = (GridView) findViewById(R.id.monthView);

        adapter = new MonthAdapter();
        monthView.setAdapter(adapter);

        monthText.setText(adapter.getCurYear()+" Year " + adapter.getCurMonth() + " Month");

        Button monthPrevious = (Button) findViewById(R.id.monthPrevios);
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setPreviousMonth();
                adapter.notifyDataSetChanged();

                monthText.setText(adapter.getCurYear()+" Year " + adapter.getCurMonth() + " Month");
            }
        });

        Button montNext = (Button) findViewById(R.id.monthNext);
        montNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setNextMonth();
                adapter.notifyDataSetChanged();

                monthText.setText(adapter.getCurYear()+" Year " + adapter.getCurMonth() + " Month");
            }
        });

        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (tmpTextView != null){
                    tmpTextView.setBackgroundColor(Color.parseColor("#fff7fbfa"));
                }

                Log.d("Listener View", String.valueOf(view));
                TextView textView = (TextView) view.findViewById(R.id.textView);
                textView.setBackgroundColor(Color.parseColor("#ffffbb33"));
                tmpTextView = textView;
            }
        });

    }

    class MonthAdapter extends BaseAdapter{
        MonthItem[] items;
        Calendar calendar;

        int curYear;
        int curMonth;

        int firstDay;
        int lastDay;
        int lastDayOfWeek;

        public MonthAdapter() {
            items = new MonthItem[7*7];

            Date date = new Date();
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.setFirstDayOfWeek(Calendar.SATURDAY);
            int firstDayOfWeek = calendar.getFirstDayOfWeek();
            Log.d("firstDayOfWeek", String.valueOf(firstDayOfWeek));

            recalculate();
            resetDayNumbers();
        }

        public void setPreviousMonth() {
            calendar.add(Calendar.MONTH, -1);

            recalculate();
            resetDayNumbers();
        }

        public void setNextMonth() {
            calendar.add(Calendar.MONTH, 1);

            recalculate();
            resetDayNumbers();
        }

        public int getCurYear(){
            return curYear;
        }

        public int getCurMonth(){
            return curMonth+1;
        }

        public void recalculate(){
            calendar.set(Calendar.DAY_OF_MONTH, 1);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            firstDay = getFirstDay(dayOfWeek);

            curYear = calendar.get(Calendar.YEAR);
            curMonth = calendar.get(Calendar.MONTH);
            lastDay = getLastDay();
            lastDayOfWeek = (lastDay - 1)%7 + firstDay;
            Log.d("lastDayOfWeek", String.valueOf(lastDayOfWeek));
            Log.d("curYear", String.valueOf(curYear));
            Log.d("curMonth", String.valueOf(curMonth));


        }



        public int getFirstDay(int dayOfWeek){
            int result = 0;
            if (dayOfWeek == Calendar.MONDAY){
                result = 0;
            } else if (dayOfWeek == Calendar.TUESDAY){
                result = 1;
            } else if (dayOfWeek == Calendar.WEDNESDAY){
                result = 2;
            } else if (dayOfWeek == Calendar.THURSDAY){
                result = 3;
            } else if (dayOfWeek == Calendar.FRIDAY){
                result = 4;
            } else if (dayOfWeek == Calendar.SATURDAY){
                result = 5;
            } else if (dayOfWeek == Calendar.SUNDAY){
                result = 6;
            }

            return result;
        }

        public int getLastDay(){
            switch (curMonth){
                case 0:
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 11:
                    return 31;
                case 3:
                case 5:
                case 8:
                case 10:
                    return 30;
                default:
                    if(((curYear%4==0)&&(curYear%100!=0)) || (curYear==0)){
                    return 29;
                    } else {
                        return 28;
                    }
            }

        }

        public void resetDayNumbers(){
            Log.d("firstDay", String.valueOf(firstDay));
            Log.d("lastDay", String.valueOf(lastDay));
            String[] dayOfWeekStr = {"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun"};
            for(int i = 0; i<7; i++){
                items[i] = new MonthItem(dayOfWeekStr[i]);
            }
            for(int i = 7; i < 49; i++){
                int dayNumber = (i-6) - firstDay;
                if(dayNumber < 1 || dayNumber > lastDay){
                    dayNumber = 0;
                }

                Log.d("dayNumber", String.valueOf(dayNumber));

                items[i] = new MonthItem(String.valueOf(dayNumber));
            }

        }


        @Override
        public int getCount() {
            if((42-(lastDay+firstDay))>=7){
                return 42;
            } else {
                return 49;
            }
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MonthitemView view = null;

            if (convertView == null) {
                view = new MonthitemView(getApplicationContext());
            } else {
                view = (MonthitemView) convertView;
            }

            view.setDay(items[position].day);

            return view;
        }
    }
}
