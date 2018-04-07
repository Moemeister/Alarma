package com.moesystems.alarma;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setAlarm(View v){

        EditText msj = (EditText) findViewById(R.id.name);
        EditText hour = (EditText) findViewById(R.id.hora);
        EditText min = (EditText) findViewById(R.id.minutos);
        Intent sendIntent = new Intent();
        sendIntent.setAction(AlarmClock.ACTION_SET_ALARM);

        if( hour.length() != 0 && min.length() != 0){
            sendIntent.putExtra(AlarmClock.EXTRA_MESSAGE, msj.getText().toString());
            sendIntent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hour.getText().toString()));
            sendIntent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(min.getText().toString()));

            if (sendIntent.resolveActivity(getPackageManager()) != null){
                startActivity(sendIntent);

            }
        }
    }
}
