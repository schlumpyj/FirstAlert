package com.example.firstalert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class MainActivity extends AppCompatActivity {

    private Incident incident;
    private ImageButton back_button;
    private TextView recent_events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        back_button = findViewById(R.id.back_button);
        recent_events = findViewById(R.id.recent_events);

        back_button.setOnClickListener(l -> {
            setInitialFragment();
        });

        setInitialFragment();
        incident = new Incident();
    }

    public void setInitialFragment() {
        ItemFragment fragment = new ItemFragment();

        FragmentManager fragmentManager =
                getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        back_button.setVisibility(View.INVISIBLE);
        recent_events.setVisibility(View.VISIBLE);
    }

    public void setIncidentView(MyItemRecyclerViewAdapter.ViewHolder viewHolder) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewHolder", viewHolder.mItem);
        FragmentManager fragmentManager =
                getSupportFragmentManager();

        incident.setArguments(bundle);

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, incident)
                .commit();

        back_button.setVisibility(View.VISIBLE);
        recent_events.setVisibility(View.GONE);
    }
}