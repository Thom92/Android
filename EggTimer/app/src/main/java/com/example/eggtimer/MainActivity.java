package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView timerTextView;
    MediaPlayer mediaPlayer;
  
    public void updateTimer(int secondsLeft)
    {
        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String secondString = Integer.toString(seconds);
        if (seconds <= 9)
        {
            secondString = "0" + secondString;
        }

        timerTextView.setText(Integer.toString(minutes)+ ":"+ secondString);
    }
    public void controlTimer(View view)
    {
        new CountDownTimer(seekBar.getProgress() * 1000, 1000)
        {

            @Override
            public void onTick(long millisUntilFinished)
            {
                updateTimer((int) millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                timerTextView.setText("0:00");
                Log.i("Finished", "Timer done");
                mediaPlayer.start();
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.editText);
        seekBar = findViewById(R.id.seekBar);


        seekBar.setMax(600);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {

                      updateTimer(progress);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
