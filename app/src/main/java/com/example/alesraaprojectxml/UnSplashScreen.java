package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class UnSplashScreen extends AppCompatActivity {
    Context context = UnSplashScreen.this;
    private Timer timer = new Timer();
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unsplich_screen);
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(context, MainWelcomeScreens.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                finish();
            }
        };
        timer.schedule(timerTask, 2000);
    }
}