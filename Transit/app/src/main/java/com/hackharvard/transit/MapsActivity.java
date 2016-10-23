package com.hackharvard.transit;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//JSON implementation

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.JsonReader;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.value;
//import static com.google.android.gms.internal.zznu.is;
/*

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

*/
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    //@Override
    /** public void onMapReady(GoogleMap googleMap) {
     mMap = googleMap;

     // Add a marker in Sydney and move the camera
     LatLng sydney = new LatLng(71.0589,42.3601);
     mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Boston"));
     mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
     }*/


    public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

        private GoogleMap mMap;
        ArrayList<String> headerLines = new ArrayList();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }


        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */
//THE CODE STARTS HERE
        public String loadJSONFromAsset() {
            String json = null;
            String a = null;
            String pop[];
            String add;
            int b = 0;

/*
        try {
         InputStream is = getAssets().open("population.json");
            BufferedReader br = new BufferedReader((is));

           StringReader f = new StringReader(is);
            String line = null;
            int lineCount = is.available();
            while ((line = br.readLine()) != null) {
                // process the line.
                if((line.startsWith("Population")) || (line.startsWith("lat")) || (line.startsWith("lng"))) {
                    heaaderLines.add(line);
                }
                lineCount ++;
            }
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        } finally {
            br.close();
        }
  */         /*
            BufferedReader reader = new BufferedReader(new FileReader(getAssets().open("Population.json")));
                    //Reader reader = new InputStreamReader();
            StringBuffer ab = new StringBuffer();
            String[] used = new String[];

            while(((a = reader.readLine()) != null)){
              ab.append(a);
                if(a.equals("Population : "))
                    pop = a.split("Population : ");
                    ab.ge
                if(a.startsWith("Bus : "))
                    add = split("Bus: ");
                if(a.startsWith("Lat : "))
                    add = split("Lat: ");
                if(a.startsWith("Long: "))
                    add = split("Long: ");
            }

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
*/
            return json;

        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            headerLines.add(0, "Population: 12");
            headerLines.add(1, "lat: -30");
            headerLines.add(2, "lng: 130");
    /*        headerLines.add(3, "Population: 20");
            headerLines.add(4, "lat: 50.231458");
            headerLines.add(5, "lng: 30.249832");
      */      for (int x = 0; x <= headerLines.size(); x++) {
                String population = headerLines.get(x).substring(12);
                x++;
                int pop = Integer.parseInt(population);
                String latitude = headerLines.get(x).substring(5);
                x++;
                double lat = Double.parseDouble(latitude);
                String longitude = headerLines.get(x).substring(5);
                double lng = Double.parseDouble(longitude);
                x++;



                if(x == 3){
                    LatLng first = new LatLng(lat, lng);

                    Marker m1 = googleMap.addMarker(new MarkerOptions().position(first));
                    if (pop > 15)
                        m1.setTitle("red");
                    else if (pop > 10)
                        m1.setTitle("Yellow Marker");
                    else if( pop <= 10)
                        m1.setTitle("green");
                }
       /*         else if (x == 6){
                    LatLng sec = new LatLng(lat, lng);
                    Marker m2 = googleMap.addMarker(new MarkerOptions().position(sec));
                    if (pop > 15)
                        m2.setTitle("red");
                    else if (pop > 10)
                        m2.setTitle("Yellow Marker");
                    else if( pop <= 10)
                        m2.setTitle("green");
                }
*/
            }

            // Add a marker in Sydney and move the camera
            //ORIGINAL IS THE USER'S ADDRESS
            // mMap.moveCamera(CameraUpdateFactory.newLatLng(original));
        }
    }

