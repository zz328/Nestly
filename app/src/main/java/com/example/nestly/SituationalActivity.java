package com.example.nestly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SituationalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_situational);
        getActionBar().setTitle("Situations");
    }
}
