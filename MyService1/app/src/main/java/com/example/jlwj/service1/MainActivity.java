package com.example.jlwj.service1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    ArrayList<SimpleData> users = new ArrayList<SimpleData>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);

        textView = (TextView)findViewById(R.id.textView6);
        textView2 = (TextView)findViewById(R.id.textView7);
        textView3 = (TextView)findViewById(R.id.textView9);
        textView4 = (TextView)findViewById(R.id.textView10);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = editText.getText().toString();
                String phone1 = editText2.getText().toString();
                String name2 = editText3.getText().toString();
                String phone2 = editText4.getText().toString();

                users.add(new SimpleData(name1, phone1));
                users.add(new SimpleData(name2, phone2));

                Intent intent = new Intent(getApplicationContext(), MyService.class);

                intent.putParcelableArrayListExtra("users", users);

                startService(intent);

            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Name");
                textView2.setText("Phone");
                textView3.setText("Name");
                textView4.setText("Phone");

            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);

        super.onNewIntent(intent);
    }

    private void processCommand(Intent intent){

        if(intent != null){
            users = intent.getExtras().getParcelableArrayList("users");

            String name1 = users.get(0).name;
            String phone1 = users.get(0).phone;
            String name2 = users.get(1).name;
            String phone2 = users.get(1).phone;

            textView.setText(name1);
            textView2.setText(phone1);
            textView3.setText(name2);
            textView4.setText(phone2);

        }
    }
}
