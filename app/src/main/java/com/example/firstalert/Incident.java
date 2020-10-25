package com.example.firstalert;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.example.firstalert.json.Item;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.InputStream;
import java.net.URL;

public class Incident extends Fragment {

    private ImageView imageView;

    public Incident() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_incident, container, false);

        Item myValue = (Item)this.getArguments().getSerializable("viewHolder");

        TextView callerText = view.findViewById(R.id.caller);
        callerText.setText(myValue.caller.s);

        CheckBox fire = view.findViewById(R.id.fire);
        fire.setChecked(myValue.fire_dept.bOOL);
        CheckBox emt = view.findViewById(R.id.emt);
        emt.setChecked(myValue.emt_dept.bOOL);
        CheckBox police = view.findViewById(R.id.police);
        police.setChecked(myValue.police_dept.bOOL);
        CheckBox urgent = view.findViewById(R.id.urgent);
        urgent.setChecked(myValue.urgent.bOOL);

        TextView notes = view.findViewById(R.id.notes);
        notes.setText(myValue.notes.s);

        Log.i("here", myValue.caller.s);
        imageView = view.findViewById(R.id.incidentImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+myValue.lat.s+","+myValue.lon.s);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });
        getImage(myValue.image.s);

        return view;
    }

    private void getImage(String id) {
        Thread thread = new Thread(() -> {
            try  {
                InputStream is = (InputStream) new URL("https://changetheindustryimages.s3.us-east-2.amazonaws.com/"+id).getContent();
                Drawable d = Drawable.createFromStream(is, "src name");

                getActivity().runOnUiThread(() -> {
                    imageView.setImageDrawable(d);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

}