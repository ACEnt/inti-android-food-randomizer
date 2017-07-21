package com.example.inti.foodrandom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView textIn;
    AutoCompleteTextView textOut;
    Button buttonAdd;
    Button buttonRemove;
    Button buttonG;
    LinearLayout container;
    ArrayList<String> mList;

    public static final String EXTRA_RESULT_LIST = "result_list";

    private static final String[] NUMBER = new String[] {
            "Pizza", "Fried Chicken", "Burger", "Pan Mee", "Hokkien Mee",
            "Char Koay Tiao", "Wan Tan Mee", "Koay Tiao Soup", "Chicken Rice", "Curry Mee"
    };
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, NUMBER);

        textIn = (AutoCompleteTextView)findViewById(R.id.textin);
        textIn.setAdapter(adapter);

        mList = new ArrayList<>();

        buttonAdd = (Button)findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);
        buttonRemove = (Button)findViewById(R.id.remove);

        buttonG = (Button)findViewById(R.id.buttonGO);

        //Button Go to proceed to new activity
        buttonG.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mList.size()==0){
                    Toast.makeText(getApplicationContext(), "No Data Insert", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                    //To pass the array data to next activity.
                    myIntent.putStringArrayListExtra(EXTRA_RESULT_LIST, mList);
                    startActivity(myIntent);
                }
            }
        });

        // Button Add to add data insert by the user.
        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);

                AutoCompleteTextView textOut = (AutoCompleteTextView)addView.findViewById(R.id.textout);
                textOut.setAdapter(adapter);
                textOut.setText(textIn.getText().toString()); //take string from text in and put string into the array.

                mList.add(textIn.getText().toString()); //added into array list

                Button buttonRemove = (Button)addView.findViewById(R.id.remove);
                textIn.setText(""); // the text inside textView beside button add will be cleared when user pressed button add.

                Toast.makeText(getApplicationContext(), "ADDED", Toast.LENGTH_LONG).show(); // Show message when the data is added.

                final View.OnClickListener thisListener = new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // When remove button was pressed, the data will be deleted.
                        ((LinearLayout)addView.getParent()).removeView(addView);
                        Toast.makeText(getApplicationContext(), "REMOVED", Toast.LENGTH_LONG).show();// Show message when the data is removed.
                        mList.remove(mList.size() - 1);
                    }
                };
                buttonRemove.setOnClickListener(thisListener);
                container.addView(addView); //textView will be added dynamically.
            }
        });
    }
}