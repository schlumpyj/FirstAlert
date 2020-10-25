package com.example.firstalert;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.example.firstalert.json.Item;
import com.example.firstalert.json.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
        callerText.setText("Caller: "+myValue.getCaller().getS());

        CheckBox fire = view.findViewById(R.id.fire);
        fire.setChecked(myValue.getFire_dept().getbOOL());
        CheckBox emt = view.findViewById(R.id.emt);
        emt.setChecked(myValue.getEmt_dept().getbOOL());
        CheckBox police = view.findViewById(R.id.police);
        police.setChecked(myValue.getPolice_dept().getbOOL());
        CheckBox urgent = view.findViewById(R.id.urgent);
        urgent.setChecked(myValue.getUrgent().getbOOL());

        TextView notes = view.findViewById(R.id.notes);
        notes.setText("Notes: " + myValue.getNotes().getS());

        Button resolveEvent = view.findViewById(R.id.resolve_event);
        resolveEvent.setOnClickListener(l -> {
            AsyncHttpClient client = new AsyncHttpClient();
            client.post("https://m7u91rzkdf.execute-api.us-east-2.amazonaws.com/pre/deleteevent?id="+myValue.getImage().getS(), new AsyncHttpResponseHandler() {
                @Override
                public void onStart() {
                    // Initiated the request
                }

                @Override
                public void onRetry(int retryNo) {
                    // Request was retried
                }

                @Override
                public void onProgress(long bytesWritten, long totalSize) {
                    // Progress notification
                }

                @Override
                public void onFinish() {
                    // Completed the request (either success or failure)
                }

                @Override
                public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                    ((MainActivity)getContext()).setInitialFragment();
                }

                @Override
                public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
        });

        Log.i("here", myValue.getCaller().getS());
        imageView = view.findViewById(R.id.incidentImage);
        imageView.setOnClickListener(v -> {
            // Create a Uri from an intent string. Use the result to create an Intent.
            Uri gmmIntentUri = Uri.parse("google.navigation:q="+myValue.getLat().getS()+","+myValue.getLon().getS());

            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");

            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
        });
        getImage(myValue.getImage().getS());

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