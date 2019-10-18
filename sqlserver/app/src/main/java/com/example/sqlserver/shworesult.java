package com.example.sqlserver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class shworesult extends AppCompatActivity {
    ListView lv ;
    String [] arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shworesult);
        lv = findViewById(R.id.list);
        Intent i1 = getIntent();
        Bundle ob = i1.getExtras();
        String id = ob.getString("name");

        try {
            Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
            String u = "http://192.168.43.165:8080/DemoAndroid/shwodetails.jsp?name="+id;
            URL url = new URL(u);

            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
             int i;
            String s="";
                 do {
                        i = in.read();
                        s+=(char) i;
                    } while (i != -1);
                 arr = s.split(",");




        } catch (MalformedURLException e) {
            Log.println(Log.ERROR, null, "" + e);
        } catch (IOException e) {
            Log.println(Log.ERROR, null, "" + e);
        }
        ArrayAdapter ad = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        lv.setAdapter(ad);

    }

    }

