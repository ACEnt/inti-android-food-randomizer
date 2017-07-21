package com.example.inti.foodrandom;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class LastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.last_activity);

        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.fragment) == null) {
            LastFragment fragment = new LastFragment();
        }
    }
}
