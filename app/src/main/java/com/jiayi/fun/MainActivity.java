package com.jiayi.fun;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, R.string.main_page_toast, Toast.LENGTH_SHORT).show();

        Button quick_enter = (Button)findViewById(R.id.quick_enter);
        quick_enter.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.jiayi.fun.PAINTING");

//                Intent intent = new Intent(MainActivity.this, PaintingActivity.class);
                if (intent.equals(null)) {
                    Log.e("fun", "intent not valid");
                } else {
                    startActivity(intent);
                }
            }
        });

        Button quick_enter_roi = (Button)findViewById(R.id.enter_roi);
        quick_enter_roi.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.jiayi.fun.ROI");

//                Intent intent = new Intent(MainActivity.this, PaintingActivity.class);
                if (intent.equals(null)) {
                    Log.e("fun", "intent not valid");
                } else {
                    startActivity(intent);
                }
            }
        });

        Button quick_enter_but = (Button)findViewById(R.id.enter_but);
        quick_enter_but.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.jiayi.fun.BUTTON");

                if (intent.equals(null)) {
                    Log.e("fun", "intent not valid");
                } else {
                    startActivity(intent);
                }
            }
        });
    }
}
