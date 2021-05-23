package com.example.status;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.status.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;


public class NetworkAdmin extends AppCompatActivity {


    TextView AMN_SW_AMNANCIEN;
    TextView AMN_SW_AMNNOUV;
    TextView AMN_SW_DPE;
    TextView AMN_SW_ELE_MC;
    TextView AMN_SW_ELE_MC1;
    TextView AMN_SW_MAG;

    TextView AMN_SW_NIT;
    TextView AMN_SW_Pers;
    TextView AMN_SW_RG36001;

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;

    TextView lcw1,lcw2,lcw3,lcw4,lcw5,lcw6,lcw7,lcw8,lcw9;

    public String jsoninfo;
    String temp;



    String notificatoin="";


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
        if (id == R.id.logout) {
            logout();

            return true;
        }
        if (id == R.id.refresh) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_network_admin);


        setTitle("Netwok Manager");
        AMN_SW_AMNANCIEN=findViewById(R.id.etat1);
        AMN_SW_AMNNOUV=findViewById(R.id.etat2);
        AMN_SW_DPE=findViewById(R.id.etat3);
        AMN_SW_ELE_MC=findViewById(R.id.etat4);
        AMN_SW_ELE_MC1=findViewById(R.id.etat5);
        AMN_SW_MAG=findViewById(R.id.etat6);

        AMN_SW_NIT=findViewById(R.id.etat7);
        AMN_SW_Pers=findViewById(R.id.etat8);
        AMN_SW_RG36001=findViewById(R.id.etat9);
        getJSON(URLs.URL_Network);


        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);

        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);

        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);

        lcw1=findViewById(R.id.lcw1);
        lcw2=findViewById(R.id.lcw2);
        lcw3=findViewById(R.id.lcw3);
        lcw4=findViewById(R.id.lcw4);
        lcw5=findViewById(R.id.lcw5);
        lcw6=findViewById(R.id.lcw6);
        lcw7=findViewById(R.id.lcw7);
        lcw8=findViewById(R.id.lcw8);
        lcw9=findViewById(R.id.lcw9);










        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"AMN_SW_AMNANCIEN");
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
                    temp=getdata(jsoninfo,"AMN_SW_AMNNOUV");
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
                    temp=getdata(jsoninfo,"AMN_SW_DPE");
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
                    temp=getdata(jsoninfo,"AMN_SW_ELE_MC");
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
                    temp=getdata(jsoninfo,"AMN_SW_ELE_MC1");
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
                    temp=getdata(jsoninfo,"AMN_SW_MAG");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"AMN_SW_NIT");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"AMN_SW_Pers");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"AMN_SW_RG36001");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });






    }
    public void getsw_lc1(String choice){

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


        lcw1.setText(date.toString());


    }
    public void getsw_lc2(String choice){

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


        lcw2.setText(date.toString());
        temp=lines[31].split("=");






    }
    public void getsw_lc3(String choice){

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


        lcw3.setText(date.toString());
        temp=lines[31].split("=");






    }
    public void getsw_lc4(String choice){

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


        lcw4.setText(date.toString());
        temp=lines[31].split("=");






    }
    public void getsw_lc5(String choice){

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


        lcw5.setText(date.toString());






    }
    public void getsw_lc6(String choice){

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


        lcw6.setText(date.toString());






    }
    public void getsw_lc7(String choice){

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


        lcw7.setText(date.toString());
        temp=lines[31].split("=");






    }
    public void getsw_lc8(String choice){

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


        lcw8.setText(date.toString());






    }
    public void getsw_lc9(String choice){

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


        lcw9.setText(date.toString());
        temp=lines[31].split("=");






    }




    public void logout(){
        Intent temp = new Intent(getBaseContext(), Login.class);
        startActivity(temp);
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
                    getAMN_SW_AMNANCIEN(s);
                    getsw_lc1("AMN_SW_AMNANCIEN");


                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getdAMN_SW_AMNNOUV(s);
                    getsw_lc2("AMN_SW_AMNNOUV");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getAMN_SW_DPE(s);
                    getsw_lc3("AMN_SW_DPE");



                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    getAMN_SW_ELE_MC(s);
                    getsw_lc4("AMN_SW_ELE_MC");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getAMN_SW_ELE_MC1(s);
                    getsw_lc5("AMN_SW_ELE_MC1");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getAMN_SW_MAG(s);
                    getsw_lc6("AMN_SW_MAG");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getAMN_SW_NIT(s);
                    getsw_lc7("AMN_SW_NIT");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getAMN_SW_Pers(s);
                    getsw_lc8("AMN_SW_Pers");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getAMN_SW_RG36001(s);
                    getsw_lc9("AMN_SW_RG36001");



                } catch (Exception e) {
                    e.printStackTrace();
                }

                showNotification(getApplicationContext()," DOWN",notificatoin,new Intent(getApplicationContext(),NetworkAdmin.class));


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
    private void getAMN_SW_AMNANCIEN(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_AMNANCIEN_val");

        if(temp==1)
        {
            AMN_SW_AMNANCIEN.setBackgroundColor(Color.GREEN);
            AMN_SW_AMNANCIEN.setText("up");
        }
        else {
            AMN_SW_AMNANCIEN.setBackgroundColor(Color.RED);
            AMN_SW_AMNANCIEN.setText("down");



            insertTorepport(getdata(json,"AMN_SW_AMNANCIEN"));

            notificatoin=notificatoin+"AMN_SW_AMNANCIEN,";

        }




    }
    @SuppressLint("SetTextI18n")
    private void getdAMN_SW_AMNNOUV(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_AMNNOUV_val");
        if(temp==1){
            AMN_SW_AMNNOUV.setBackgroundColor(Color.GREEN);
            AMN_SW_AMNNOUV.setText("up");

        }else {
            AMN_SW_AMNNOUV.setBackgroundColor(Color.RED);
            AMN_SW_AMNNOUV.setText("down");
            insertTorepport(getdata(json,"AMN_SW_AMNNOUV"));


            notificatoin=notificatoin+"AMN_SW_AMNNOUV,";

        }





    }



    @SuppressLint("SetTextI18n")
    private void getAMN_SW_DPE(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_DPE_val");
        if(temp==1){
            AMN_SW_DPE.setBackgroundColor(Color.GREEN);
            AMN_SW_DPE.setText("up");
        }else {
            AMN_SW_DPE.setBackgroundColor(Color.RED);
            AMN_SW_DPE.setText("down");
            insertTorepport(getdata(json,"AMN_SW_DPE"));


            notificatoin=notificatoin+"AMN_SW_DPE,";


        }


    }

    @SuppressLint("SetTextI18n")
    private void getAMN_SW_ELE_MC(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_ELE_MC_val");
        if(temp==1){
            AMN_SW_ELE_MC.setBackgroundColor(Color.GREEN);
            AMN_SW_ELE_MC.setText("up");
        }else {
            AMN_SW_ELE_MC.setBackgroundColor(Color.RED);
            AMN_SW_ELE_MC.setText("down");
            insertTorepport(getdata(json,"AMN_SW_ELE_MC"));


            notificatoin=notificatoin+"AMN_SW_ELE_MC,";

        }


    }


    @SuppressLint("SetTextI18n")
    private void getAMN_SW_ELE_MC1(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_ELE_MC1_val");
        if(temp==1){
            AMN_SW_ELE_MC1.setBackgroundColor(Color.GREEN);
            AMN_SW_ELE_MC1.setText("up");
        }else {
            AMN_SW_ELE_MC1.setBackgroundColor(Color.RED);
            AMN_SW_ELE_MC1.setText("down");

            insertTorepport(getdata(json,"AMN_SW_ELE_MC1"));




            notificatoin=notificatoin+"AMN_SW_ELE_MC1,";
        }


    }

    @SuppressLint("SetTextI18n")
    private void getAMN_SW_MAG(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_MAG_val");
        if(temp==1){
            AMN_SW_MAG.setBackgroundColor(Color.GREEN);
            AMN_SW_MAG.setText("up");
        }else {
            AMN_SW_MAG.setBackgroundColor(Color.RED);
            AMN_SW_MAG.setText("down");

            insertTorepport(getdata(json,"AMN_SW_MAG"));


            notificatoin=notificatoin+"AMN_SW_MAG,";
        }


    }
    @SuppressLint("SetTextI18n")
    private void getAMN_SW_NIT(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_NIT_val");
        if(temp==1){
            AMN_SW_NIT.setBackgroundColor(Color.GREEN);
            AMN_SW_NIT.setText("up");
        }else {
            AMN_SW_NIT.setBackgroundColor(Color.RED);
            AMN_SW_NIT.setText("down");
            insertTorepport(getdata(json,"AMN_SW_NIT"));


            notificatoin=notificatoin+"AMN_SW_NIT,";

        }


    }
    @SuppressLint("SetTextI18n")
    private void getAMN_SW_Pers(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_Pers_val");
        if(temp==1){
            AMN_SW_Pers.setBackgroundColor(Color.GREEN);
            AMN_SW_Pers.setText("up");
        }else {
            AMN_SW_Pers.setBackgroundColor(Color.RED);
            AMN_SW_Pers.setText("down");

            insertTorepport(getdata(json,"AMN_SW_Pers"));


            notificatoin=notificatoin+"AMN_SW_Pers,";

        }


    }
    @SuppressLint("SetTextI18n")
    private void getAMN_SW_RG36001(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("AMN_SW_RG36001_val");
        if(temp==1){
            AMN_SW_RG36001.setBackgroundColor(Color.GREEN);
            AMN_SW_RG36001.setText("up");
        }else {
            AMN_SW_RG36001.setBackgroundColor(Color.RED);
            AMN_SW_RG36001.setText("down");
            insertTorepport(getdata(json,"AMN_SW_RG36001"));


            notificatoin=notificatoin+"AMN_SW_RG36001,";

        }


    }

    public void navigatetoInfo(String s){
        Intent temp=new Intent(getApplicationContext(),Info.class);
        temp.putExtra("data",s);
        startActivity(temp);
    }

    public String getdata(String json,String choix) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        return   jsonObject.getString(choix);
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

    public void insertTorepport(final String ch){



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

                params.put("data",ch);


                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_addRapport, params);
            }
        }
        add ul = new add();
        ul.execute();






    }

}













