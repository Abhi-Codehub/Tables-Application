package com.example.tablesapplications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView tablesListView;

    public void generateTable(int tablesNumber){
        ArrayList<String> tablesContent = new ArrayList<String>();

        for (int j = 1; j<=20; j++){
            tablesContent.add(Integer.toString(j * tablesNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tablesContent);
        tablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tablesSeekbar = findViewById(R.id.tablesSeekBar);
        tablesListView = findViewById(R.id.tablesListViews);

        int max =100;
        int startingPosition =2;

        tablesSeekbar.setMax(max);
        tablesSeekbar.setProgress(startingPosition);
        generateTable(startingPosition);
        tablesSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min =2;
                int tablesNumber;
                if (i<min){
                    tablesNumber = min;
                    tablesSeekbar.setProgress(min);

                } else {
                    tablesNumber = i ;
                }
                Log.i("Seekbar value" , Integer.toString(tablesNumber));
                generateTable(tablesNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
