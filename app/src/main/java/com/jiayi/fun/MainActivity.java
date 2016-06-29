package com.jiayi.fun;

import android.preference.ListPreference;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import android.app.Activity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, R.string.main_page_toast, Toast.LENGTH_LONG).show();
    }
}
