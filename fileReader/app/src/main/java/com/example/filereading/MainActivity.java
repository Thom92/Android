package com.example.filereading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity
{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRaw();
       textView = findViewById(R.id.readFromFile);
        textView.setMovementMethod(new ScrollingMovementMethod());
        String data = "";
        StringBuffer sb = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.kingleon);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if(is != null)
        {
            try
            {
                while((data = reader.readLine()) != null)
                {
                    sb.append(data + "\n");
                }
                textView.setText(sb);
                is.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try {


            final String path = "C:\\Users\\Thoma\\Github\\androidUdemy\\fileReader\\app\\src\\main\\res\\raw";
            Log.d("Files", "Path: " + path);
            File directory = new File(path);
            File[] files = directory.listFiles();
            Log.d("Files", "Size: " + files.length);
            for (int i = 0; i < files.length; i++) {
                Log.d("Files", "FileName:" + files[i].getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void listRaw()
    {
        Field[] fields = R.raw.class.getFields();


            for (int count = 0; count < fields.length; count++) {
                Log.i("Raw asset", fields[count].getName() + "\n");

            }
    }
}
