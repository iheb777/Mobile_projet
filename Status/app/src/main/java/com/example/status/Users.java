package com.example.status;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Users extends AppCompatActivity {
    TableLayout tl;


    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.layout.usermenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add) {
            startActivity(new Intent(getBaseContext(),Adduser.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

            setTitle("All users");


         tl = (TableLayout) findViewById(R.id.tableUsers);






        TableRow tr_header = new TableRow(this);
        //header
        tr_header.setId(10);
        tr_header.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
//creation de row
        TextView label_hello = new TextView(this);
        label_hello.setId(20);
        label_hello.setText("Users");
         label_hello.setTextColor(Color.BLACK);

// part2
        label_hello.setPadding(5, 5, 5, 5);
        tr_header.addView(label_hello);// add the column to the table row here

        TextView label_android = new TextView(this);    // part3
        label_android.setId(21);// define id that must be unique
        label_android.setText("Role"); // set the text for the header
        label_android.setTextColor(Color.BLACK); // set the color

        label_android.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_header.addView(label_android); //

        TextView label_hello1 = new TextView(this);
        label_hello1.setId(20);
        label_hello1.setText("UPDATE");
        label_hello1.setBackgroundColor(Color.BLUE);
        label_hello1.setTextColor(Color.WHITE);
         label_hello1.setGravity(Gravity.CENTER);

// part2
        label_hello1.setPadding(5, 5, 5, 5);
        tr_header.addView(label_hello1);// add the column to the table row here

        TextView label_hello2 = new TextView(this);
        label_hello2.setId(20);
        label_hello2.setText("DELETE");
        label_hello2.setBackgroundColor(Color.RED);
        label_hello2.setTextColor(Color.WHITE);
         label_hello2.setGravity(Gravity.CENTER);

// part2
        label_hello2.setPadding(5, 5, 5, 5);
        tr_header.addView(label_hello2);// add the column to the table row here

        tl.addView(tr_header, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,                    //part4
                TableLayout.LayoutParams.WRAP_CONTENT));

//)))))))))))))))))))))))

getJSON(URLs.URL_Users);





    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {
            TableRow[] tr_head = new TableRow[45];
            TextView[] textArray = new TextView[45];



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
                    JSONArray userJson = obj.getJSONArray("users");


                    for(int i=0; i<userJson.length();i++) {

                        final JSONObject temp = userJson.getJSONObject(i);
                        final TableRow tableRow = new TableRow(getBaseContext());
                        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

                        // Creation textView
                        final TextView text = new TextView(getBaseContext());
                        text.setText(temp.getString("user"));
                        text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));



                        // Creation textView
                        final TextView text1 = new TextView(getBaseContext());
                        text1.setText(temp.getString("role"));
                        text1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                        // Creation  button
                        final Button button = new Button(getBaseContext());
                        button.setText("Update");
                        button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                     Intent x =new Intent(getBaseContext(),UpdateUser.class);
                                    x.putExtra("data",temp.toString());
                                    startActivity(x);


                            }
                        });

                        final Button button1 = new Button(getBaseContext());
                        button1.setText("Delete");

                        button1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                        button1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Log.e("fin","a");


                                final TableRow parent = (TableRow) v.getParent();
                                tl.removeView(parent);
                                try {


                                    deletuser(temp.getInt("id"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                        tableRow.addView(text);
                        tableRow.addView(text1);

                        tableRow.addView(button);
                        tableRow.addView(button1);

                        tl.addView(tableRow);
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

    private void deletuser(int id) {
        final int iduser;
        iduser=id;

        class Deletuser extends AsyncTask<Void, Void, String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters


                HashMap<String, String> params = new HashMap<>();

                params.put("id",iduser+"");


                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_DeleteUsers, params);
            }
        }


        Deletuser ul = new Deletuser();
        ul.execute();



    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

        startActivity(new Intent(this,SuperAdmin.class));
    }
}