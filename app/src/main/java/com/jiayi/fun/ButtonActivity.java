package com.jiayi.fun;

import android.app.Activity;
import android.graphics.drawable.Drawable;
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


        float density = getResources().getDisplayMetrics().density;
        Log.e(TAG, "density : " + density);

        Button but_selfie = (Button)findViewById(R.id.selfie);
        Drawable drawable_selfie = getResources().getDrawable(R.drawable.drawable_selfie);
        drawable_selfie.setBounds(0, 0, (int)(drawable_selfie.getMinimumWidth()/density), (int)(drawable_selfie.getMinimumHeight()/density));
        Log.e(TAG, "width : " +  drawable_selfie.getMinimumWidth() + ";  height : " +  drawable_selfie.getMinimumHeight());
        but_selfie.setCompoundDrawables(null, null, drawable_selfie, null);
        Log.e(TAG, "but_selfie.getText() : " + but_selfie.getText());


        Button but_video = (Button)findViewById(R.id.video);
        Drawable drawable_video = getResources().getDrawable(R.drawable.drawable_video);
        drawable_video.setBounds(0, 0, (int)(drawable_video.getMinimumWidth()/density), (int)(drawable_video.getMinimumHeight()/density));
        but_video.setCompoundDrawables(null, null, drawable_video, null);

        Button but_photo = (Button)findViewById(R.id.photo);
        Drawable drawable_photo = getResources().getDrawable(R.drawable.drawable_photo);
        drawable_photo.setBounds(0, 0, (int)(drawable_photo.getMinimumWidth()/density), (int)(drawable_photo.getMinimumHeight()/density));
        but_photo.setCompoundDrawables(null, null, drawable_photo, null);


    }
}
