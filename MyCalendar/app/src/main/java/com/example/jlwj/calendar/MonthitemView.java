package com.example.jlwj.calendar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.color.holo_orange_light;

/**
 *
 */

public class MonthitemView extends RelativeLayout {
    TextView textView;
    public MonthitemView(Context context) {
        super(context);

        init(context);
    }

    public MonthitemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.month_item, this, true);

        Log.d("context", String.valueOf(context));
        Log.d("this", String.valueOf(this));

        textView = (TextView) findViewById(R.id.textView);
    }

    public void setDay(String dayStr) {

        if (dayStr == String.valueOf(0)){
            textView.setText("");
        } else {
            textView.setText(dayStr);

        }
    }


}
