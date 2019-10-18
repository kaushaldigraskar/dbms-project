package com.example.sqlserver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    Button insert,showdetails;
    EditText name,adress,designation,branch,mobile,date,qualification,blood_grp,college_passot;
    ProgressBar progressBar;
    String uname,Designation,Branch,Mobile,Date,Qualification,Blood_grp,College_passot;
    String Address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        mobile=findViewById(R.id.mobile);
        date= findViewById(R.id.date);
        qualification = findViewById(R.id.qualification);
        blood_grp=findViewById(R.id.blood_grp);
        college_passot=findViewById(R.id.passout_clg);
        adress = findViewById(R.id.Adress);
        showdetails= findViewById(R.id.button);
        designation = findViewById(R.id.Designation);
        branch = findViewById(R.id.Branch);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        insert = findViewById(R.id.button2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname = name.getText().toString();
                Address = adress.getText().toString();
                Designation = designation.getText().toString();
                Branch = branch.getText().toString();
                Mobile = mobile.getText().toString();
                Date = date.getText().toString();
                Qualification = qualification.getText().toString();
                Blood_grp = blood_grp.getText().toString();
                College_passot = college_passot.getText().toString();


                try {
                    String u = "http://192.168.43.165:8080/DemoAndroid/newjsp.jsp?name=" + uname + "&address=" + Address + "&designation=" + Designation + "&branch=" + Branch+"&mobile="+Mobile+"&date="+Date+"&qualification="+Qualification+"&blood_group="+Blood_grp+"&passout_college="+College_passot;
                    URL url = new URL(u);

                    URLConnection connection = url.openConnection();
                    InputStream in = connection.getInputStream();
                   int i;
                   String s="";
                    do {
                        i = in.read();
                        s+=(char) i;
                    } while (i != -1);

                    Toast.makeText(MainActivity.this, "Data inserted successfully"+Mobile+Date+Qualification+Blood_grp+College_passot , Toast.LENGTH_SHORT).show();

                } catch (MalformedURLException e) {
                    Log.println(Log.ERROR, null, "" + e);
                } catch (IOException e) {
                    Log.println(Log.ERROR, null, "" + e);
                }
            }
        });
        showdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname = name.getText().toString();
                Intent  i = new Intent(MainActivity.this,shworesult.class);
                i.putExtra("name",uname);
                startActivity(i);

            }
        });

    }}