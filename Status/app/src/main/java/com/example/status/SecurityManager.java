package com.example.status;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class SecurityManager extends AppCompatActivity {
    TextView etatdvr1;
    TextView etatdvr2;
    TextView etatnvrarpo;
    TextView etatnvrdru;
    TextView cametatextprincipal;
    TextView camint;

    Button b1,b2,b3,b4,b5,b6;

    TextView lc1,ltd1,lc2,ltd2,lc3,ltd3,lc4,ltd4,lc5,ltd5,lc6,ltd6;

    public String jsoninfo;
    String temp;


    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.layout.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id==R.id.refresh){
            Toast.makeText(this,"refre is clicked",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.logout){
            Toast.makeText(this,"log is clicked",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void logout(){
        Intent temp = new Intent(getBaseContext(), Login.class);
        startActivity(temp);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_manager);

        setTitle("Security Manager");
        etatdvr1=findViewById(R.id.etatdvr1);
        etatdvr2=findViewById(R.id.etatdvr2);
        etatnvrarpo=findViewById(R.id.etatnvrarpo);
        etatnvrdru=findViewById(R.id.nvrdru);
        cametatextprincipal=findViewById(R.id.cametatextprincipal);
        camint=findViewById(R.id.camint);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);

        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);


        getJSON(URLs.URL_Security);


        lc1=findViewById(R.id.lc1);
        ltd1=findViewById(R.id.ltd1);
        lc2=findViewById(R.id.lc2);
        ltd2=findViewById(R.id.ltd2);
        lc3=findViewById(R.id.lc3);
        ltd3=findViewById(R.id.ltd3);
        lc4=findViewById(R.id.lc4);
        ltd4=findViewById(R.id.ltd4);
        lc5=findViewById(R.id.lc5);
        ltd5=findViewById(R.id.ltd5);
        lc6=findViewById(R.id.lc6);
        ltd6=findViewById(R.id.ltd6);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"dvr1info");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"dvr2info");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"nvrarpoinfo");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"extprincipalinfo");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"camintinfo");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"nvrdruinfo");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });




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
                jsoninfo=s;

                super.onPostExecute(s);
                // Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    getdvr1(s);
                    getcam_lc1("dvr1info");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getdvr2(s);
                    getcam_lc2("dvr2info");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getnvr1(s);
                    getcam_lc3("nvrarpoinfo");



                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    getnvrdru(s);
                    getcam_lc4("extprincipalinfo");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getcamint(s);
                    getcam_lc5("camintinfo");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getextprincipal(s);
                    getcam_lc6("nvrdruinfo");



                } catch (Exception e) {
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

    @SuppressLint("SetTextI18n")
    private void getdvr1(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("dvr1");

        if(temp==1)
        {
            etatdvr1.setBackgroundColor(Color.GREEN);
            etatdvr1.setText("up");
        }
        else {
            etatdvr1.setBackgroundColor(Color.RED);
            etatdvr1.setText("down");
            insertTorepport(getdata(json,"dvr1info"));

            showNotification(getApplicationContext(),"DOWN","AMN_CAM_DVR1",new Intent(getApplicationContext(),SecurityManager.class));

        }




    }

    public void getcam_lc1(String choice){

        String a= null;
        try {
            a = getdata(jsoninfo,choice);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] lines = a.split(System.getProperty("line.separator"));

        String[] temp = null;
        temp=lines[22].split("=");

        Date date = new Date(Long.parseLong(temp[1]));


        lc1.setText(date.toString());
        temp=lines[31].split("=");

        date = new Date(Long.parseLong(temp[1]));
        ltd1.setText(date.toString());




    }
    public void getcam_lc2(String choice){

        String a= null;
        try {
            a = getdata(jsoninfo,choice);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] lines = a.split(System.getProperty("line.separator"));

        String[] temp = null;
        temp=lines[22].split("=");

        Date date = new Date(Long.parseLong(temp[1]));


        lc2.setText(date.toString());
        temp=lines[31].split("=");

        date = new Date(Long.parseLong(temp[1]));
        ltd2.setText(date.toString());




    }
    public void getcam_lc3(String choice){

        String a= null;
        try {
            a = getdata(jsoninfo,choice);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] lines = a.split(System.getProperty("line.separator"));

        String[] temp = null;
        temp=lines[22].split("=");

        Date date = new Date(Long.parseLong(temp[1]));


        lc2.setText(date.toString());
        temp=lines[31].split("=");

        date = new Date(Long.parseLong(temp[1]));
        ltd2.setText(date.toString());




    }
    public void getcam_lc4(String choice){

        String a= null;
        try {
            a = getdata(jsoninfo,choice);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] lines = a.split(System.getProperty("line.separator"));

        String[] temp = null;
        temp=lines[22].split("=");

        Date date = new Date(Long.parseLong(temp[1]));


        lc4.setText(date.toString());
        temp=lines[31].split("=");

        date = new Date(Long.parseLong(temp[1]));
        ltd4.setText(date.toString());




    }
    public void getcam_lc5(String choice){

        String a= null;
        try {
            a = getdata(jsoninfo,choice);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] lines = a.split(System.getProperty("line.separator"));

        String[] temp = null;
        temp=lines[22].split("=");

        Date date = new Date(Long.parseLong(temp[1]));


        lc5.setText(date.toString());
        temp=lines[31].split("=");

        date = new Date(Long.parseLong(temp[1]));
        ltd5.setText(date.toString());




    }
    public void getcam_lc6(String choice){

        String a= null;
        try {
            a = getdata(jsoninfo,choice);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] lines = a.split(System.getProperty("line.separator"));

        String[] temp = null;
        temp=lines[22].split("=");

        Date date = new Date(Long.parseLong(temp[1]));


        lc6.setText(date.toString());
        temp=lines[31].split("=");

        date = new Date(Long.parseLong(temp[1]));
        ltd6.setText(date.toString());




    }





    @SuppressLint("SetTextI18n")
    private void getdvr2(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("dvr2");
        if(temp==1){
            etatdvr2.setBackgroundColor(Color.GREEN);
            etatdvr2.setText("up");

        }else {
            etatdvr2.setBackgroundColor(Color.RED);
            etatdvr2.setText("down");
            insertTorepport(getdata(json,"dvr2info"));

            showNotification(getApplicationContext(),"DOWN","AMN_CAM_DVR2",new Intent(getApplicationContext(),SecurityManager.class));

        }





    }

    public String getdata(String json,String choix) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
         return   jsonObject.getString(choix);
    }

    @SuppressLint("SetTextI18n")
    private void getnvr1(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("nvrarpo");
        if(temp==1){
            etatnvrarpo.setBackgroundColor(Color.GREEN);
            etatnvrarpo.setText("up");
        }else {
            etatnvrarpo.setBackgroundColor(Color.RED);
            etatnvrarpo.setText("down");
            insertTorepport(getdata(json,"nvrarpoinfo"));
            showNotification(getApplicationContext(),"DOWN","APPRO_CAM_NVR",new Intent(getApplicationContext(),SecurityManager.class));



        }


    }

    @SuppressLint("SetTextI18n")
    private void getnvrdru(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("nvrdru");
        if(temp==1){
            etatnvrdru.setBackgroundColor(Color.GREEN);
            etatnvrdru.setText("up");
        }else {
            etatnvrdru.setBackgroundColor(Color.RED);
            etatnvrdru.setText("down");
            insertTorepport(getdata(json,"nvrdruinfo"));

            showNotification(getApplicationContext(),"DOWN","DRU_CAM_NVR",new Intent(getApplicationContext(),SecurityManager.class));



        }


    }


    @SuppressLint("SetTextI18n")
    private void getextprincipal(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("extprincipal");
        if(temp==1){
            cametatextprincipal.setBackgroundColor(Color.GREEN);
            cametatextprincipal.setText("up");
        }else {
            cametatextprincipal.setBackgroundColor(Color.RED);
            cametatextprincipal.setText("down");

            insertTorepport(getdata(json,"extprincipalinfo"));

            showNotification(getApplicationContext(),"DOWN","DRU_CAM_EXT_PRINCIPALE",new Intent(getApplicationContext(),SecurityManager.class));



        }


    }

    @SuppressLint("SetTextI18n")
    private void getcamint(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("camint");
        if(temp==1){
            camint.setBackgroundColor(Color.GREEN);
            camint.setText("up");
        }else {
            camint.setBackgroundColor(Color.RED);
            camint.setText("down");
            insertTorepport(getdata(json,"camintinfo"));

            showNotification(getApplicationContext(),"DOWN","DRU_CAM_INT",new Intent(getApplicationContext(),SecurityManager.class));



        }


    }

    public void navigatetoInfo(String s){
        Intent temp=new Intent(getApplicationContext(),Info.class);
        temp.putExtra("data",s);
        startActivity(temp);
    }


     public void showNotification(Context context, String title, String body, Intent intent) {


             NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

             int notificationId = 1;
             String channelId = "channel-01";
             String channelName = "Channel Name";
             int importance = NotificationManager.IMPORTANCE_HIGH;

             if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                 NotificationChannel mChannel = new NotificationChannel(
                         channelId, channelName, importance);
                 notificationManager.createNotificationChannel(mChannel);
             }

             NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                     .setSmallIcon(R.mipmap.ic_launcher)
                     .setContentTitle(title)
                     .setContentText(body);

             TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
             stackBuilder.addNextIntent(intent);
             PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                     0,
                     PendingIntent.FLAG_UPDATE_CURRENT
             );
             mBuilder.setContentIntent(resultPendingIntent);

             notificationManager.notify(notificationId, mBuilder.build());


         Toast.makeText(getApplicationContext(), body+" IS DOWN", Toast.LENGTH_SHORT).show();

     }

    public void insertTorepport(final String ch) {


        class add extends AsyncTask<Void, Void, String> {


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

                params.put("data", ch);


                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_addRapport, params);
            }
        }
        add ul = new add();
        ul.execute();


    }
        }















