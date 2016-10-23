package com.hackharvard.transit;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;

import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.Toast;
import android.content.Intent;
import android.widget.EditText;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

//import javax.swing.JOptionPane;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button mysubmit;
    private EditText startaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startaddress = (EditText)findViewById(R.id.editText2) ;
        findViewById(R.id.button3).setOnClickListener(this);
      /**  mysubmit = (Button) findViewById(R.id.button3);
        mysubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        }); **/


        // public void go(View v)
        //{
     //   Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();

        // JSONObject obj = new JSONObject();
        //obj.put("Name", "crunchify.com");
        //obj.put("Author", "App Shah");

        //String jsonString = JSONObject.toString();

        //try (FileWriter file = new FileWriter("/Users/JakiranLamba/Desktop/file1.txt")) {
        // file.write(obj.toJSONString());
        // System.out.println("Successfully Copied JSON Object to File...");
        // System.out.println("\nJSON Object: " + obj);
        //}

        //public void starting_point(View V)
        //{
        //  EditText s_point = (EditText) findViewById(R.id.edit_first_name);
        //s_point.getText().toString();
        //}
        //public void ending_point(View V){

        //}
    }


    public void onClick(View v){
        String theString = startaddress.getText().toString();
        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("key", theString);
        startActivity(intent);

    }
}
