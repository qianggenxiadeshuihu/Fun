package com.jiayi.fun;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


public class ROIActivity extends Activity {

    private final String TAG = "com.jiayi.fun";
    private int current_frame = 0;
    private String pre_path = null;
    private final String post_path = ".csv";
    private final int FRAME_NUMBER_START = 1;
    private final int FRAME_NUMBER_END = 100;
    private final int ROI_SIZE = 7;

    private TextView [] roi_row = new TextView[ROI_SIZE];

    private ArrayList<String> get_roi(String path) {
        FileInputStream is = null;
        try {
            is = new FileInputStream(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = null;
        ArrayList<String> roi_content = new ArrayList<>();
        try {
            while ((line = reader.readLine()) != null) {
                roi_content.add(line);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return roi_content;

    }

    public void show_roi(int current_frame) {

        ArrayList<String> roi;
        StringTokenizer st = null;
        int i = 0;
        Log.e(TAG, pre_path + String.valueOf(current_frame) + post_path);
        roi = get_roi(pre_path + String.valueOf(current_frame) + post_path);
        if (roi == null) {
            Toast.makeText(getApplicationContext(),
                    "please check your input for directory which should be prefix of filename before number\t" +
                    "for example: /data/test/ungrounded_copper_iris",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        while(!roi.isEmpty()) {
            String temp = "";
            Log.e(TAG, roi.get(0));
            st = new StringTokenizer(roi.get(0), ",");
            while (st.hasMoreTokens()) {
                temp = temp.concat(String.format("%10s", st.nextToken()));
            }
            roi_row[i++].setText(temp);
            roi.remove(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roi);


        roi_row[0] = (TextView)findViewById(R.id.row_1);
        roi_row[1] = (TextView)findViewById(R.id.row_2);
        roi_row[2] = (TextView)findViewById(R.id.row_3);
        roi_row[3] = (TextView)findViewById(R.id.row_4);
        roi_row[4] = (TextView)findViewById(R.id.row_5);
        roi_row[5] = (TextView)findViewById(R.id.row_6);
        roi_row[6] = (TextView)findViewById(R.id.row_7);


        Button next = (Button)findViewById(R.id.show_next_roi);
        next.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_frame < FRAME_NUMBER_END) {
                    show_roi(++current_frame);
                } else {
                    Log.e(TAG, "you have been the last one");
                    Toast.makeText(getApplicationContext(), "you have been the last one", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button prev = (Button)findViewById(R.id.show_prev_roi);
        prev.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_frame > FRAME_NUMBER_START) {
                    show_roi(--current_frame);
                } else {
                    Log.e(TAG, "you have been the first one");
                    Toast.makeText(getApplicationContext(), "you have been the first one", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button record_dir = (Button)findViewById(R.id.record_dir);

        record_dir.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText data_dir = (EditText)findViewById(R.id.data_dir);
                pre_path = data_dir.getText().toString();
                pre_path = pre_path.replace("/", "//");
                show_roi(FRAME_NUMBER_START);
            }
        });
    }
}
