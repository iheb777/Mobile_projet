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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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


public class SystemAdmin extends AppCompatActivity {
    TextView APPRO_SRV_DHCP_KAV;
    TextView DRU_SRV_AD;
    TextView DRU_SRV_Backup;
    TextView DRU_SRV_ESXI_GPM3;
    TextView DRU_SRV_GLPI_ANCIEN;
    TextView DRU_SRV_GPM3;

    TextView DRU_SRV_GPM3_Backp;
    TextView DRU_SRV_GedAlfresco;
    TextView DRU_SRV_Helpdesk;

    TextView DRU_SRV_KAV_HYP;

    TextView DRU_SRV_AD_Service;
    TextView DRU_SRV_Backup_Service;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    TextView ltd1,ltd2,ltd3,ltd4,ltd5,ltd6,ltd7,ltd8,ltd9,ltd10,ltd11,ltd12;

    public String jsoninfo;
    String temp;
    String notification="";

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
            Toast.makeText(this,"log1 is clicked", Toast.LENGTH_SHORT).show();

            return true;
        }
        if (id == R.id.refresh) {
            Toast.makeText(this,"ref is clicked", Toast.LENGTH_SHORT).show();

            return true;
        }


        return super.onOptionsItemSelected(item);
    }




    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_system_admin);
        setTitle("Server Manager");


        APPRO_SRV_DHCP_KAV=findViewById(R.id.etat1);
        DRU_SRV_AD=findViewById(R.id.etat2);
        DRU_SRV_Backup=findViewById(R.id.etat3);
        DRU_SRV_ESXI_GPM3=findViewById(R.id.etat4);
        DRU_SRV_GLPI_ANCIEN=findViewById(R.id.etat5);
        DRU_SRV_GPM3=findViewById(R.id.etat6);

        DRU_SRV_GPM3_Backp=findViewById(R.id.etat7);
        DRU_SRV_GedAlfresco=findViewById(R.id.etat8);
        DRU_SRV_Helpdesk=findViewById(R.id.etat9);
        DRU_SRV_KAV_HYP=findViewById(R.id.etat10);
        DRU_SRV_AD_Service=findViewById(R.id.etat11);
        DRU_SRV_Backup_Service=findViewById(R.id.etat12);


        getJSON(URLs.URL_System);


        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);

        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);

        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b10=findViewById(R.id.b10);
        b11=findViewById(R.id.b11);
        b12=findViewById(R.id.b12);



        ltd1=findViewById(R.id.lt1);
        ltd2=findViewById(R.id.lt2);
        ltd3=findViewById(R.id.lt3);
        ltd4=findViewById(R.id.lt4);
        ltd5=findViewById(R.id.lt5);
        ltd6=findViewById(R.id.lt6);
        ltd7=findViewById(R.id.lt7);
        ltd8=findViewById(R.id.lt8);
        ltd9=findViewById(R.id.lt9);
        ltd10=findViewById(R.id.lt10);
        ltd11=findViewById(R.id.lt11);

        ltd12=findViewById(R.id.lt12);









        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"APPRO_SRV_DHCP_KAV");
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
                    temp=getdata(jsoninfo,"DRU_SRV_AD");
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
                    temp=getdata(jsoninfo,"DRU_SRV_Backup");
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
                    temp=getdata(jsoninfo,"DRU_SRV_ESXI_GPM3");
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
                    temp=getdata(jsoninfo,"DRU_SRV_GLPI_ANCIEN");
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
                    temp=getdata(jsoninfo,"DRU_SRV_GPM3");
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
                    temp=getdata(jsoninfo,"DRU_SRV_GPM3_Backp");
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
                    temp=getdata(jsoninfo,"DRU_SRV_GedAlfresco");
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
                    temp=getdata(jsoninfo,"DRU_SRV_Helpdesk");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"DRU_SRV_KAV_HYP");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"DRU_SRV_AD_Service");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp=getdata(jsoninfo,"DRU_SRV_Backup_Service");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                navigatetoInfo(temp);


            }
        });






    }
    public void getsw_lt1(String choice){

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


        ltd1.setText(date.toString());


    }
    public void getsw_lt2(String choice){

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


        ltd2.setText(date.toString());


    }
    public void getsw_lt3(String choice){

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


        ltd3.setText(date.toString());


    }
    public void getsw_lt4(String choice){

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


        ltd4.setText(date.toString());


    }
    public void getsw_lt5(String choice){

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


        ltd5.setText(date.toString());


    }
    public void getsw_lt6(String choice){

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


        ltd6.setText(date.toString());


    }
    public void getsw_lt7(String choice){

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


        ltd7.setText(date.toString());


    }
    public void getsw_lt8(String choice){

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


        ltd8.setText(date.toString());


    }
    public void getsw_lt9(String choice){

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


        ltd9.setText(date.toString());


    }
    public void getsw_lt10(String choice){

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


        ltd10.setText(date.toString());


    }

    public void getsw_lt11(String choice){

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


        ltd11.setText(date.toString());


    }

    public void getsw_lt12(String choice){

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


        ltd11.setText(date.toString());


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
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            protected void onPostExecute(String s) {
                jsoninfo=s;

                super.onPostExecute(s);
                // Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    getAPPRO_SRV_DHCP_KAV(s);
                    getsw_lt1("APPRO_SRV_DHCP_KAV");


                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getdDRU_SRV_AD(s);
                    getsw_lt2("DRU_SRV_AD");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getDRU_SRV_Backup(s);
                    getsw_lt3("DRU_SRV_Backup");



                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    getDRU_SRV_ESXI_GPM3(s);
                    getsw_lt4("DRU_SRV_ESXI_GPM3");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getDRU_SRV_GLPI_ANCIEN(s);
                    getsw_lt5("DRU_SRV_GLPI_ANCIEN");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getDRU_SRV_GPM3(s);
                    getsw_lt6("DRU_SRV_GPM3");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getDRU_SRV_GPM3_Backp(s);
                    getsw_lt7("DRU_SRV_GPM3_Backp");


                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getDRU_SRV_GedAlfresco(s);
                    getsw_lt8("DRU_SRV_GedAlfresco");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getDRU_SRV_Helpdesk(s);
                    getsw_lt9("DRU_SRV_Helpdesk");



                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    getDRU_SRV_KAV_HYP(s);
                    getsw_lt10("DRU_SRV_KAV_HYP");




                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    getDRU_SRV_AD_Service(s);
                    getsw_lt11("DRU_SRV_AD_Service");




                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    getDRU_SRV_Backup_Service(s);
                    getsw_lt12("DRU_SRV_Backup_Service");




                } catch (Exception e) {
                    e.printStackTrace();
                }

                showNotification(getApplicationContext(),"DOWN",notification,new Intent(getApplicationContext(),SecurityManager.class));

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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetTextI18n")
    private void getAPPRO_SRV_DHCP_KAV(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("APPRO_SRV_DHCP_KAV_val");

        if(temp==1)
        {
            APPRO_SRV_DHCP_KAV.setBackgroundColor(Color.GREEN);
            APPRO_SRV_DHCP_KAV.setText("up");
        }
        else {
            APPRO_SRV_DHCP_KAV.setBackgroundColor(Color.RED);
            APPRO_SRV_DHCP_KAV.setText("down");
            insertTorepport(getdata(json,"APPRO_SRV_DHCP_KAV"));


            notification=notification+"APPRO_SRV_DHCP_KAV,";
        }




    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetTextI18n")
    private void getdDRU_SRV_AD(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_AD_val");
        if(temp==1){
            DRU_SRV_AD.setBackgroundColor(Color.GREEN);
            DRU_SRV_AD.setText("up");

        }else {
            DRU_SRV_AD.setBackgroundColor(Color.RED);
            DRU_SRV_AD.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_AD"));


            notification=notification+"DRU_SRV_AD,";
        }





    }




    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_AD_Service(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_AD_Service_val");
        if(temp==1){
            DRU_SRV_AD_Service.setBackgroundColor(Color.GREEN);
            DRU_SRV_AD_Service.setText("up");

        }else {
            DRU_SRV_AD_Service.setBackgroundColor(Color.RED);
            DRU_SRV_AD_Service.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_AD_Service"));


            notification=notification+"DRU_SRV_AD_Service,";
        }





    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_Backup_Service(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_Backup_Service_val");
        if(temp==1){
            DRU_SRV_Backup_Service.setBackgroundColor(Color.GREEN);
            DRU_SRV_Backup_Service.setText("up");

        }else {
            DRU_SRV_Backup_Service.setBackgroundColor(Color.RED);
            DRU_SRV_Backup_Service.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_Backup_Service"));


            notification=notification+"DRU_SRV_Backup_Service,";
        }





    }





    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_Backup(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_Backup_val");
        if(temp==1){
            DRU_SRV_Backup.setBackgroundColor(Color.GREEN);
            DRU_SRV_Backup.setText("up");
        }else {
            DRU_SRV_Backup.setBackgroundColor(Color.RED);
            DRU_SRV_Backup.setText("down");

            insertTorepport(getdata(json,"DRU_SRV_Backup"));


            notification=notification+"DRU_SRV_Backup,";
        }


    }

    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_ESXI_GPM3(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_ESXI_GPM3_val");
        if(temp==1){
            DRU_SRV_ESXI_GPM3.setBackgroundColor(Color.GREEN);
            DRU_SRV_ESXI_GPM3.setText("up");
        }else {
            DRU_SRV_ESXI_GPM3.setBackgroundColor(Color.RED);
            DRU_SRV_ESXI_GPM3.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_ESXI_GPM3"));


            notification=notification+"DRU_SRV_ESXI_GPM3,";

        }


    }


    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_GLPI_ANCIEN(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_GLPI_ANCIEN_val");
        if(temp==1){
            DRU_SRV_GLPI_ANCIEN.setBackgroundColor(Color.GREEN);
            DRU_SRV_GLPI_ANCIEN.setText("up");
        }else {
            DRU_SRV_GLPI_ANCIEN.setBackgroundColor(Color.RED);
            DRU_SRV_GLPI_ANCIEN.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_GLPI_ANCIEN"));



            notification=notification+"DRU_SRV_GLPI_ANCIEN,";

        }


    }

    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_GPM3(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_GPM3_val");
        if(temp==1){
            DRU_SRV_GPM3.setBackgroundColor(Color.GREEN);
            DRU_SRV_GPM3.setText("up");
        }else {
            DRU_SRV_GPM3.setBackgroundColor(Color.RED);
            DRU_SRV_GPM3.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_GPM3"));


            notification=notification+"DRU_SRV_GPM3,";

        }


    }
    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_GPM3_Backp(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_GPM3_Backp_val");
        if(temp==1){
            DRU_SRV_GPM3_Backp.setBackgroundColor(Color.GREEN);
            DRU_SRV_GPM3_Backp.setText("up");
        }else {
            DRU_SRV_GPM3_Backp.setBackgroundColor(Color.RED);
            DRU_SRV_GPM3_Backp.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_GPM3_Backp"));



            notification=notification+"DRU_SRV_GPM3_Backp,";
        }


    }
    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_GedAlfresco(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_GedAlfresco_val");
        if(temp==1){
            DRU_SRV_GedAlfresco.setBackgroundColor(Color.GREEN);
            DRU_SRV_GedAlfresco.setText("up");
        }else {
            DRU_SRV_GedAlfresco.setBackgroundColor(Color.RED);
            DRU_SRV_GedAlfresco.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_GedAlfresco"));



            notification=notification+"DRU_SRV_GedAlfresco,";


        }


    }
    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_Helpdesk(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_Helpdesk_val");
        if(temp==1){
            DRU_SRV_Helpdesk.setBackgroundColor(Color.GREEN);
            DRU_SRV_Helpdesk.setText("up");
        }else {
            DRU_SRV_Helpdesk.setBackgroundColor(Color.RED);
            DRU_SRV_Helpdesk.setText("down");
            insertTorepport(getdata(json,"DRU_SRV_Helpdesk"));


            notification=notification+"DRU_SRV_Helpdesk,";

        }


    }

    @SuppressLint("SetTextI18n")
    private void getDRU_SRV_KAV_HYP(String json) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);
        int temp= (int)jsonObject.getInt("DRU_SRV_KAV_HYP_val");
        if(temp==1){
            DRU_SRV_KAV_HYP.setBackgroundColor(Color.GREEN);
            DRU_SRV_KAV_HYP.setText("up");
        }else {
            DRU_SRV_KAV_HYP.setBackgroundColor(Color.RED);
            DRU_SRV_KAV_HYP.setText("down");

            insertTorepport(getdata(json,"DRU_SRV_KAV_HYP"));



            notification=notification+"DRU_SRV_KAV_HYP,";
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


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
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


        Toast.makeText(getApplicationContext(), body+" DOWN", Toast.LENGTH_SHORT).show();

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
