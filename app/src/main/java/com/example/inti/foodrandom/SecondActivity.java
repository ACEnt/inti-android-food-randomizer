package com.example.inti.foodrandom;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Alex on Jul-17.
 */

public class SecondActivity extends AppCompatActivity {

    ArrayList<String> mList;
    Button buttonBack;
    Button buttonM;
    TextView mShowTextTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_activity);

        mShowTextTextView = (TextView) findViewById(R.id.showText);

        mList = new ArrayList<>();

        Intent startActivityIntent = getIntent();
        if (startActivityIntent.hasExtra(MainActivity.EXTRA_RESULT_LIST))
            //Get array data from previous activity.
            mList = startActivityIntent.getStringArrayListExtra(MainActivity.EXTRA_RESULT_LIST);
        else {
            //To check whether the array data passes to this activity or not.
            throw new UnsupportedOperationException("No data fetched from previous Activity");
        }

        mShowTextTextView.setText(getRandomString());

        buttonBack=(Button)findViewById(R.id.buttonBack); // To go back previous activity.
        buttonBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(SecondActivity.this,
                        MainActivity.class);
                startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


        buttonM=(Button)findViewById(R.id.buttonMap); // Go to map in next activity.
        buttonM.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent lastActivityIntent = new Intent(SecondActivity.this, LastActivity.class);
                startActivity(lastActivityIntent);
            }
        });
    }

    private String getRandomString() {
        int index = new Random().nextInt(mList.size()); //random the array data.

        return mList.get(index);// show the chosen random data.
    }

    private String getListOfItemsAsString() {
        String catString = "";
        for (String item : mList) {
            catString += item + "\n";
        }

        return catString;
    }

}
