package com.example.status;
import android.app.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Login extends Activity {
    Button buttonLogin, b2;
    EditText editTextUsername, editTextPassword;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Intent t = new Intent(getBaseContext(), SuperAdmin.class);
        //  startActivity(t);

        editTextUsername = (EditText) findViewById(R.id.editText);
        editTextPassword = (EditText) findViewById(R.id.editText2);

        b2 = (Button) findViewById(R.id.button2);
        tx1 = (TextView) findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });





        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void userLogin() {
        //first getting the values
        final String username = editTextUsername.getText().toString();
        final String password = editTextPassword.getText().toString();

        //validating inputs
        if (TextUtils.isEmpty(username)) {
            editTextUsername.setError("Please enter your username");
            editTextUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please enter your password");
            editTextPassword.requestFocus();
            return;
        }




        class UserLogin extends AsyncTask<Void, Void, String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.e("iheb",s);


                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        JSONObject userJson = obj.getJSONObject("userdata");


                        //creating a new user object
                        String username = userJson.getString("user");
                        String role = userJson.getString("role");
                        Log.e("iheb",role);

                        if(role.equals("super")){
                            finish();
                            startActivity(new Intent(getApplicationContext(), SuperAdmin.class));

                        }else if(role.equals("network")){
                            finish();
                            startActivity(new Intent(getApplicationContext(), NetworkAdmin.class));

                        }else   if(role.equals("system")){
                            finish();
                            startActivity(new Intent(getApplicationContext(), SystemAdmin.class));

                        }else   if(role.equals("security")){
                            finish();
                            startActivity(new Intent(getApplicationContext(), SecurityManager.class));
                        }else {
                            Toast.makeText(getApplicationContext(), "This client has no role",Toast.LENGTH_SHORT).show();
                            tx1.setVisibility(View.VISIBLE);
                            tx1.setBackgroundColor(Color.RED);
                            counter--;
                            tx1.setText(Integer.toString(counter));
                            Log.e("te",counter+"");
                            if (counter == 0) {
                                buttonLogin.setEnabled(false);
                            }

                        }


                    }

                    else

                    {
                        Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();

                        tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.RED);
                        counter--;
                        tx1.setText(Integer.toString(counter));
                        Log.e("iheb",counter+"");
                        if (counter == 0) {
                            buttonLogin.setEnabled(false);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();

                params.put("user", username);
                params.put("password", password);


                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_LOGIN, params);
            }
        }


        UserLogin ul = new UserLogin();
        ul.execute();


    }



}
