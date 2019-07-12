package com.example.sensorsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor mSensor;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        txt = findViewById(R.id.txt);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        StringBuilder builder = new StringBuilder();
        builder.append("x : "+sensorEvent.values[0]+"\n");
        builder.append("y : "+sensorEvent.values[1]+"\n");
        builder.append("z : "+sensorEvent.values[2]+"\n");
        txt.setText(builder.toString());
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
