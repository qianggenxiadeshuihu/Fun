package com.jiayi.fun;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ButtonActivity extends Activity {

    private final String TAG = "com.jiayi.fun";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button but_selfie = (Button)findViewById(R.id.selfie);
        Button but_vedio = (Button)findViewById(R.id.vedio);
        Button but_photo = (Button)findViewById(R.id.photo);

        ImageView img_selfie = (ImageView)findViewById(R.id.selfie_image);
        img_selfie.setImageResource(R.drawable.ic_selfie);
        ImageView img_vedio = (ImageView)findViewById(R.id.vedio_image);
        img_vedio.setImageResource(R.drawable.ic_video);
        ImageView img_photo = (ImageView)findViewById(R.id.photo_image);
        img_photo.setImageResource(R.drawable.ic_photo);

    }
}
