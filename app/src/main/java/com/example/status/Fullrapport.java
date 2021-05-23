package com.example.status;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class Fullrapport extends AppCompatActivity {

    TableLayout tl;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullrapport);
        setTitle("All rapports");

        tl = (TableLayout) findViewById(R.id.tablerapport);
        TableRow tr_header = new TableRow(this);
        tr_header.setId(10);
        tr_header.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        TextView label_hello = new TextView(this);
        label_hello.setId(20);
        label_hello.setText("Equipement DOWN");
        label_hello.setTextColor(Color.BLACK);

// part2
        label_hello.setPadding(5, 5, 5, 5);
        tr_header.addView(label_hello);// add the column to the table row here


        tl.addView(tr_header, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,                    //part4
                TableLayout.LayoutParams.WRAP_CONTENT));



        getJSON(URLs.URL_Rapport);

    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {


            //this method will be called before execution
            //you can display a progress bar or something
            //so that user can understand that he should wait
            //as network operation may take some time
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            //this method will be called after execution
            //so here we are displaying a toast with the json string
            @Override
            protected void onPostExecute(String s) {

                super.onPostExecute(s);

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);
                    JSONArray userJson = obj.getJSONArray("rapport");


                    for(int i=0; i<userJson.length();i++) {

                        final JSONObject temp = userJson.getJSONObject(i);


                        Log.e("aa",temp.toString());
                        String data="";

                        data=temp.getString("data");
                        if(!data.equals("")){

                            String[] lines = data.split(System.getProperty("line.separator"));





                            final TableRow tableRow = new TableRow(getBaseContext());
                            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

                            // Creation textView
                            final TextView text = new TextView(getBaseContext());
                            text.setText("---->"+lines[0]);
                            text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));



                            tableRow.addView(text);



                            tl.addView(tableRow);

                            final TableRow tableRow1 = new TableRow(getBaseContext());
                            tableRow1.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));



                            // Creation textView
                            final TextView text1 = new TextView(getBaseContext());

                            String []tab1=lines[30].split("=");
                            Long l1=Long.parseLong(tab1[1]);
                            Date a=new Date(l1);
                            text1.setText("   *Last time up : "+a.toString());
                            text1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));


                            tableRow1.addView(text1);


                            tl.addView(tableRow1);




                            final TableRow tableRow2 = new TableRow(getBaseContext());
                            tableRow2.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));



                            // Creation textView
                            final TextView text2 = new TextView(getBaseContext());
                            String []tab=lines[31].split("=");

                            Long l2=Long.parseLong(tab[1]);
                            Date b=new Date(l2);
                            text2.setText("   *Last time down : "+b.toString());

                            text2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));


                            tableRow2.addView(text2);


                            tl.addView(tableRow2);

                        }

                    }





                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            //in this method we are fetching the json string
            @Override
            protected String doInBackground(Void... voids) {



                try {
                    //creating a URL
                    URL url = new URL(urlWebService);

                    //Opening the URL using HttpURLConnection
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    //StringBuilder object to read the string from the service
                    StringBuilder sb = new StringBuilder();

                    //We will use a buffered reader to read the string from service
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    //A simple string to read values from each line
                    String json;

                    //reading until we don't find null
                    while ((json = bufferedReader.readLine()) != null) {

                        //appending it to string builder
                        sb.append(json + "\n");
                    }

                    //finally returning the read string
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }

            }
        }

        //creating asynctask object and executing it
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }



}