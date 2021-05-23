package com.example.status;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuperAdmin extends AppCompatActivity {

    Button cam,srv,sw,logout,full,users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_admin);


        setTitle("Super Admin");
        cam=findViewById(R.id.cam);
        srv=findViewById(R.id.srv);
        logout=findViewById(R.id.logout);
        sw=findViewById(R.id.sw);
        full=findViewById(R.id.full);
        users=findViewById(R.id.gereruser);



        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecurityManager.class));
            }
        });
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),NetworkAdmin.class));
            }
        });
        srv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SystemAdmin.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Fullrapport.class));


            }

        });
        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Users.class));
            }
        });




    }
}
