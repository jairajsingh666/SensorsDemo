package com.example.sensorsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class GetSensorListActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_sensor_list);

        txt = findViewById(R.id.txt);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder builder = new StringBuilder();
        int pc = 0;
        for(Sensor s : deviceSensors){
            builder.append(++pc + ". "+s.getName()+"\n");
        }
        txt.setText(builder.toString());
    }
}
