package com.example.languagephrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonTapped(View view)
    {
        int id = view.getId();
        String ourId = "";
        ourId = view.getResources().getResourceEntryName(id);

        int ressourceId = getResources().getIdentifier(ourId, "raw", "com.example.languagephrases");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, ressourceId);
        mediaPlayer.start();
        Log.i("Button tapped", ourId);


    }
}
