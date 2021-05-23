package com.example.status;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class UpdateUser extends AppCompatActivity {


    RadioGroup radioGroup;
    JSONObject userdata;
    String username;
    String password;
    String role;
    EditText userinput,passinut;
    Button update;
    int iduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        setTitle("Update user");

        userinput=findViewById(R.id.username);
        passinut=findViewById(R.id.password);
        update=findViewById(R.id.btnupdate);
        radioGroup=findViewById(R.id.radioGroup);

        String data=getIntent().getExtras().getString("data");
        try {
             userdata = new JSONObject(data);
          username=userdata.getString("user");
            password=userdata.getString("password");
            role=userdata.getString("role");
            iduser=userdata.getInt("id");




        } catch (JSONException e) {
            e.printStackTrace();
        }





        userinput.setText(username);
        passinut.setText(password);

        update=findViewById(R.id.btnupdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                class Deletuser extends AsyncTask<Void, Void, String> {


                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();

                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        Log.e("iheb",s+"res");

                    }

                    @Override
                    protected String doInBackground(Void... voids) {
                        //creating request handler object
                        RequestHandler requestHandler = new RequestHandler();

                        //creating request parameters


                        HashMap<String, String> params = new HashMap<>();

                        params.put("id",iduser+"");
                        params.put("user",userinput.getText().toString());
                        params.put("password",passinut.getText().toString());

                        int id= radioGroup.getCheckedRadioButtonId();
                        final View radioButton = radioGroup.findViewById(id);

                        params.put("role",radioButton.getTag().toString());


                        //returing the response
                        return requestHandler.sendPostRequest(URLs.URL_UpdateUsers, params);
                    }
                }


                Deletuser ul = new Deletuser();
                ul.execute();
                startActivity(new Intent(getBaseContext(),Users.class));




            }
        });



    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

        startActivity(new Intent(this,SuperAdmin.class));
    }
}