package com.example.status;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    TextView tv;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        setTitle("All the information");

         TextView[] textArray = new TextView[45];


        TableRow[] tr_head = new TableRow[45];


       // tv=findViewById(R.id.information);
        //tv.setMovementMethod(new ScrollingMovementMethod());

        TableLayout tl = (TableLayout) findViewById(R.id.tableInvoices);
        String data="";

        data=getIntent().getExtras().getString("data");
        String[] lines = data.split(System.getProperty("line.separator"));






        TableRow tr_header = new TableRow(this);
        tr_header.setId(10);
        tr_header.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        TextView label_hello = new TextView(this);
        label_hello.setId(20);
        label_hello.setText("Option");
        label_hello.setBackgroundColor(Color.BLUE);
        label_hello.setTextColor(Color.WHITE);
        label_hello.setBackgroundColor(Color.BLUE);
        label_hello.setGravity(Gravity.CENTER);

// part2
        label_hello.setPadding(5, 5, 5, 5);
        tr_header.addView(label_hello);// add the column to the table row here

        TextView label_android = new TextView(this);    // part3
        label_android.setId(21);// define id that must be unique
        label_android.setText("State"); // set the text for the header
        label_android.setTextColor(Color.WHITE); // set the color
        label_hello.setBackgroundColor(Color.GRAY);

        label_android.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_header.addView(label_android); //

        tl.addView(tr_header, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,                    //part4
                TableLayout.LayoutParams.WRAP_CONTENT));






        for(int i=0; i<45;i++) {

            tr_head[i] = new TableRow(this);
            tr_head[i].setId(i + 1);
            tr_head[i].setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            // Here create the TextView dynamically


            String[] temp = null;


             temp=lines[i].split("=");

            textArray[i] = new TextView(this);
            textArray[i].setId(i + 111);
            textArray[i].setText(temp[0]);
             textArray[i].setPadding(5, 5, 5, 5);

            tr_head[i].addView(textArray[i]);

            textArray[i] = new TextView(this);
            textArray[i].setId(i + 111);

            try {
                textArray[i].setText(temp[1]);
            }     catch ( Exception e){
                 textArray[i].setText("Sorry no data");

            }

             textArray[i].setPadding(5, 5, 5, 5);


            tr_head[i].addView(textArray[i]);





            tl.addView(tr_head[i], new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));


        }

    }




}
