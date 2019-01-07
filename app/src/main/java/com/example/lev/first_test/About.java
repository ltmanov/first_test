package com.example.lev.first_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView spiel = findViewById(R.id.textView3);

        Button goHome = findViewById(R.id.buttonAb);

        spiel.setText("A Haiku ...\n\n\nThis Application \n\nhas many features yet few\n\nare satisfactory.");
        spiel.setTextSize(24);

        goHome.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent jk = new Intent( About.this, main.class);
                        startActivity(jk);
                    }
                }
        );

    }
}
