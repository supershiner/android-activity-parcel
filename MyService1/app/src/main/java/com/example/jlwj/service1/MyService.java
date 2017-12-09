package com.example.jlwj.service1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.ArrayList;


public class MyService extends Service {
    ArrayList<SimpleData> users = new ArrayList<SimpleData>();

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(intent == null){
            return  Service.START_STICKY;
        }else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent){

        users = intent.getExtras().getParcelableArrayList("users");

        try{
            Thread.sleep(2000);
        }catch(Exception e){

        }

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);

        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                Intent.FLAG_ACTIVITY_SINGLE_TOP|
                Intent.FLAG_ACTIVITY_CLEAR_TOP);

        showIntent.putParcelableArrayListExtra("users", users);

        startActivity(showIntent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
