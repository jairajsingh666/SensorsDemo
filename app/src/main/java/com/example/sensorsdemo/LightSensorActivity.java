package com.example.sensorsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LightSensorActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor mSensor;
    TextView txt;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        txt = findViewById(R.id.txt);
        rl = findViewById(R.id.rl);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        txt.setText("light : "+sensorEvent.values[0]+" lumens");
        if(sensorEvent.values[0]>400){
            rl.setBackgroundColor(getResources().getColor(R.color.dark));
        }else if(sensorEvent.values[0]>200){
            rl.setBackgroundColor(getResources().getColor(R.color.red));
        }else if(sensorEvent.values[0]>100){
            rl.setBackgroundColor(getResources().getColor(R.color.blue));
        }else {
            rl.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
