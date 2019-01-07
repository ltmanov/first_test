package com.example.lev.first_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Rating extends AppCompatActivity {

    public RatingBar rater;
    public String songName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Button returnMe = findViewById(R.id.buttonR);
        TextView songToBe = findViewById(R.id.textView2);
        rater = findViewById(R.id.ratingBar);

        songName = getIntent().getStringExtra("song");

        songToBe.setText(songName);
        songToBe.setTextSize(50);


        returnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = new Intent();
                String message=Float.toString(rater.getRating());
                r.putExtra("rating", message);
                r.putExtra("songName", songName);
                setResult(RESULT_OK, r);
                finish();
                }
            }
        );

    }
}
