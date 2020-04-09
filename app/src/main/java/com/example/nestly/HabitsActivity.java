package com.example.nestly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HabitsActivity extends AppCompatActivity {

    private FirebaseDatabase myBase;
    private DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Habits");
        setContentView(R.layout.activity_habits);
      
        myBase = FirebaseDatabase.getInstance();
        dbref = myBase.getReference();
      
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor pe = sp.edit();

        //who do you identify as
        final Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.identify_as, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pe.putString("habits_identify",spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //checkboxes
        final CheckBox cb1= findViewById(R.id.checkbox1);
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked()) {
                    pe.putBoolean("habits_cb1",true);
                }
            }
        });
        final CheckBox cb2= findViewById(R.id.checkbox2);
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb2.isChecked()) {
                    pe.putBoolean("habits_cb2",true);
                }
            }
        });
        final CheckBox cb3= findViewById(R.id.checkbox3);
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb3.isChecked()) {
                    pe.putBoolean("habits_cb3",true);
                }
            }
        });
        final CheckBox cb4= findViewById(R.id.checkbox4);
        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb4.isChecked()) {
                    pe.putBoolean("habits_cb4",true);
                }
            }
        });
        final CheckBox cb5= findViewById(R.id.checkbox5);
        cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb5.isChecked()) {
                    pe.putBoolean("habits_cb5",true);
                }
            }
        });
        final CheckBox cb6= findViewById(R.id.checkbox6);
        cb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb6.isChecked()) {
                    pe.putBoolean("habits_cb6",true);
                }
            }
        });

        //time spend in room
        final Spinner spinner2 = findViewById(R.id.spinner2);
        Integer[] items = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pe.putInt("habits_hours_inroom",Integer.parseInt(spinner2.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //wake up time
        final Spinner spinner3 = findViewById(R.id.spinner3);
        String[] times = new String[]{"8pm", "9pm", "10pm", "11pm", "12am", "1am", "2am", "3am", "4am", "5am", "6am"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, times);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pe.putString("habits_wakeup",spinner3.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //sleep time
        final Spinner spinner4 = findViewById(R.id.spinner4);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter2);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pe.putString("habits_sleep",spinner4.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //bring friends
        final Spinner spinner5 = findViewById(R.id.spinner5);
        String [] frequency = new String[]{"1","2","3","5","6","7","8","9","10+"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, frequency);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter3);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pe.putString("habits_bring_friends", spinner5.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void gotoSituations(View view) {
        Intent intent = new Intent(this, SituationalActivity.class);
        startActivity(intent);
    }
}
