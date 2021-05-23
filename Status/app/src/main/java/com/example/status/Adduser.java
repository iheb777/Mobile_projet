package com.example.status;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import org.json.JSONObject;

import java.util.HashMap;

public class Adduser extends AppCompatActivity {



    RadioGroup radioGroup;
    EditText userinput,passinut;
    Button add;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        setTitle("Add user");


         userinput=findViewById(R.id.usernameadd);
         passinut=findViewById(R.id.passwordadd);
         add=findViewById(R.id.btnadd);
         radioGroup=findViewById(R.id.radioGroupadd);
         add=findViewById(R.id.btnadd);


         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 class adduser extends AsyncTask<Void, Void, String> {


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

                         params.put("user",userinput.getText().toString());
                         params.put("password",passinut.getText().toString());

                         int id= radioGroup.getCheckedRadioButtonId();
                         final View radioButton = radioGroup.findViewById(id);

                         params.put("role",radioButton.getTag().toString());


                         //returing the response
                         return requestHandler.sendPostRequest(URLs.URL_addUsers, params);
                     }
                 }


                 adduser ul = new adduser();
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