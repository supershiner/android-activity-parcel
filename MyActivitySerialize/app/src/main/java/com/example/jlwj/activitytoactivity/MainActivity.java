package com.example.jlwj.activitytoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;

    ArrayList<String> mans = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "Main onCreate() has been called", Toast.LENGTH_LONG).show();

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                //intent.putExtra("name", "jakson");
                //setResult(Activity.RESULT_OK, intent);
                mans.add("jackson");
                mans.add("mykal");
                intent.putExtra("mans", mans);

                startActivityForResult(intent, 101);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "Main onActivityResult() has been called", Toast.LENGTH_LONG).show();

        if(requestCode == 101){
            ArrayList<String> wives = (ArrayList<String>)data.getSerializableExtra("wives");

            textView.setText("Serail : " + wives.get(0));
            textView2.setText("Serail : " + wives.get(1));

            //data.putExtra("name", "jakson");
            //setResult(Activity.RESULT_OK, data);

        }
    }
}
