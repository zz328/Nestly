package com.example.nestly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LongAnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_answer);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor pe = sp.edit();

        Button button = findViewById(R.id.long_answer_finish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = findViewById(R.id.long_answer1);
                pe.putString("long_answer_1",editText1.getText().toString());
                EditText editText2 = findViewById(R.id.long_answer2);
                pe.putString("long_answer_2",editText2.getText().toString());
                EditText editText3 = findViewById(R.id.long_answer3);
                pe.putString("long_answer_3",editText3.getText().toString());
                EditText editText4 = findViewById(R.id.long_answer4);
                pe.putString("long_answer_4",editText4.getText().toString());
            }
        });

    }

    public void gotoHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
