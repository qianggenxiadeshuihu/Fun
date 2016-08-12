package com.jiayi.fun;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;


public class PaintingActivity extends Activity {

    public Vibrator vib_instance;
    private boolean flag = false;

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
    }

}
