package com.example.felipe.myapplication;

import android.os.Bundle;
import android.support.annotation.UiThread;
import android.util.Log;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.felipe.myapplication.services.DoneTaskListener;
import com.example.felipe.myapplication.services.ProcessTask;
import com.example.felipe.myapplication.services.ProcessValueTask;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DoneTaskListener {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);
        executeTask();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    @Override
    public void onDoneCompleted(Double value) {
        tv.setText(String.format(Locale.UK, "On this thread: %f", value));
    }

    public void executeTask(){
        ProcessTask task = new ProcessValueTask(this);
        task.execute(900.0);
    }
}
