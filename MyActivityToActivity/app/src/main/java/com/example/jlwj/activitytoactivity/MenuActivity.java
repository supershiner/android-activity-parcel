package com.example.jlwj.activitytoactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;

    ArrayList<SimpleData> datas = new ArrayList<SimpleData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);

        Intent from_main_intent = getIntent();

        processIntent(from_main_intent);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                datas.add(new SimpleData("mykal", "010-1000-1000"));
                datas.add(new SimpleData("jackson", "020-2000-2000"));

                intent.putExtra("datas", datas);

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }

    private void processIntent(Intent intent){
        if(intent !=null){

            datas = intent.getExtras().getParcelableArrayList("datas");

            if(datas != null){
                textView.setText("Parcel : " + datas.get(0).name);
                textView2.setText("Parcel : " + datas.get(0).phone);

            }
        }
    }


}
