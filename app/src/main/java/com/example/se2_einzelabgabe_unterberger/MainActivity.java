package com.example.se2_einzelabgabe_unterberger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void messageSend(View view) {
        EditText nr_bearbeiten= findViewById(R.id.nr_bearbeiten);
        String text = nr_bearbeiten.getText().toString();
        TextView tv = findViewById(R.id.text_output);

        try {
            thread_tcp thread = new thread_tcp(text);
            thread.start();

            thread.join();

            tv.setText(thread.getServer_output());

        } catch (Exception e) {
            tv.setText(e.toString());
        }
}}