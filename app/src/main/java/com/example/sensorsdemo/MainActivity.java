package com.example.sensorsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCLick(View view){
        int id = view.getId();
        Intent intent = null;
        switch (id){
            case R.id.button: intent = new Intent(MainActivity.this,GetSensorListActivity.class);break;
            case R.id.button2: intent = new Intent(MainActivity.this,AccelerometerActivity.class);break;
            case R.id.button3: intent = new Intent(MainActivity.this,LightSensorActivity.class);break;
            case R.id.button4: intent = new Intent(MainActivity.this,GetSensorListActivity.class);break;
        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}
