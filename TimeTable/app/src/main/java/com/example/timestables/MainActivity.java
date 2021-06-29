package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timeTableListView;

    public void generateTimesTable(int timesTable)
    {
        ArrayList<String> timesTableContent = new ArrayList<>();

        for(int i = 1; i<10; i++)
        {
            timesTableContent .add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timeTableListView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekbar = findViewById(R.id.timesTableSeekBar);
       timeTableListView = findViewById(R.id.timeTableListView);

        timesTablesSeekbar.setMax(20);
        timesTablesSeekbar.setProgress(10);
        timesTablesSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                int min = 1;
                int timeTable;

                if(progress < min)
                {
                    timeTable = min;
                    timesTablesSeekbar.setProgress(min);
                }
                else
                {
                    timeTable = progress;
                }

                generateTimesTable(timeTable);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        generateTimesTable(10);
    }
}
