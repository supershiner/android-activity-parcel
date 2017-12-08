package com.example.jlwj.activitytoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;

    ArrayList<SimpleData> datas = new ArrayList<SimpleData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                datas.add(new SimpleData("mykal", "010-1000-1000"));
                datas.add(new SimpleData("jackson", "020-2000-2000"));

                intent.putParcelableArrayListExtra("datas", datas);

                startActivityForResult(intent, 101);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){

            datas = data.getExtras().getParcelableArrayList("datas");

            if(datas != null){
                textView.setText("Parcel : " + datas.get(1).name);
                textView2.setText("Parcel : " + datas.get(1).phone);

            }
        }
    }
}
