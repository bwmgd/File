package com.example.file;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private final String MyFileName = "a.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(v -> {
            OutputStream out;
            try {
                FileOutputStream fileOutputStream = openFileOutput(MyFileName, MODE_PRIVATE);
                out = new BufferedOutputStream(fileOutputStream);
                String content = "2018011322,yhm";
                try {
                    out.write(content.getBytes(StandardCharsets.UTF_8));
                } finally {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        findViewById(R.id.button2).setOnClickListener(v -> {
            InputStream in;
            try {
                FileInputStream fileInputStream = openFileInput(MyFileName);
                in = new BufferedInputStream(fileInputStream);
                int c;
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    while ((c = in.read()) != -1) {
                        stringBuilder.append((char) c);
                    }
                    Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
                } finally {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}