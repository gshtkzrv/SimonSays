package com.example.zara.simonsays;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.click_animation);

        Button redButton = (Button) findViewById(R.id.redButton);
        Button greenButton = (Button) findViewById(R.id.greenButton);
        Button yellowButton = (Button) findViewById(R.id.yellowButton);
        Button blueButton = (Button) findViewById(R.id.blueButton);

        /*Button[] allButtons = {redButton, greenButton, yellowButton, blueButton};
        RandomThread rndThread = new RandomThread(allButtons, animation);
        rndThread.start();
        for (int i = 0; i < 5; i++) {
            rndThread.run();
        }*/

        redButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Button redButton = (Button) findViewById(R.id.redButton);
                Button greenButton = (Button) findViewById(R.id.greenButton);
                Button yellowButton = (Button) findViewById(R.id.yellowButton);
                Button blueButton = (Button) findViewById(R.id.blueButton);
                final Button[] allButtons = {redButton, greenButton, yellowButton, blueButton};
                final Random buttonNumber = new Random();
                for (int i = 0; i < 5; i++) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            allButtons[buttonNumber.nextInt(4)].startAnimation(animation);
                        }
                    }, 2000);
                }
                if (!animation.hasStarted() || animation.hasEnded()) {
                    view.startAnimation(animation);
                }
                //Toast.makeText(MainActivity.this, "You clicked the real button!", Toast.LENGTH_LONG).show();
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!animation.hasStarted() || animation.hasEnded()) {
                    view.startAnimation(animation);
                }
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!animation.hasStarted() || animation.hasEnded()) {
                    view.startAnimation(animation);
                }
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!animation.hasStarted() || animation.hasEnded()) {
                    view.startAnimation(animation);
                }
            }
        });

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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
}
