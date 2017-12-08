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

    ArrayList<String> wives = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Toast.makeText(this, "Menu onCreate() has been called", Toast.LENGTH_LONG).show();

        Intent from_main_intent = getIntent();

        wives.add("jackson's wife");
        wives.add("mykal's wife");

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);

        processIntent(from_main_intent);
        //String name = intent.getStringExtra("mans");


        //textView2.setText("Sended Data : " + name);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("wives", wives);

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }

    private void processIntent(Intent intent){
        if(intent !=null){
            ArrayList<String> mans = (ArrayList<String>)intent.getSerializableExtra("mans");

            if(mans != null){
                textView.setText("Serial : " + mans.get(0));
                textView2.setText("Serial : " + mans.get(1));

            }
        }
    }


}
