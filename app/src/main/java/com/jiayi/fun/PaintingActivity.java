package com.jiayi.fun;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;


public class PaintingActivity extends Activity implements SensorEventListener{

    private Vibrator vib_instance;
    private boolean flag = false;
    private SensorManager sensorManager;
    private Sensor accel_sensor;
    private EditText accel_value;
    private Button get_accel;

    @Override
    public void onSensorChanged(SensorEvent event) {
//            Toast.makeText(PaintingActivity.this, event.values[0] + "  " + event.values[1] + "  " + event.values[2] + "  ", Toast.LENGTH_SHORT).show();
        accel_value.setText(String.format("%f  %f  %f", event.values[0], event.values[1], event.values[2]));
//            Log.d("fun_value", String.format("%f  %f  %f", event.values[0], event.values[1], event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Toast.makeText(PaintingActivity.this, "onAccuracyChanged", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);

        Button start_vib = (Button)findViewById(R.id.start_vib);
        vib_instance = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        start_vib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = !flag;
                Toast.makeText(PaintingActivity.this, String.valueOf(flag), Toast.LENGTH_SHORT).show();
                if (flag) {
                    vib_instance.vibrate(10000000);
                } else {
                    vib_instance.cancel();
                }
            }
        });

        get_accel = (Button)findViewById(R.id.show_accel);
        accel_value = (EditText)findViewById(R.id.accel_value);

        sensorManager = (SensorManager)getApplicationContext().getSystemService(Context.SENSOR_SERVICE);
        accel_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        sensorManager.registerListener(this, accel_sensor, 1000000);

    }
}
