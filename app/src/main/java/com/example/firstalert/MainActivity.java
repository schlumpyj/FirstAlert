package com.example.firstalert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class MainActivity extends AppCompatActivity {

    private Incident incident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialFragment();
        incident = new Incident();
    }

    private void setInitialFragment() {
        ItemFragment fragment = new ItemFragment();

        FragmentManager fragmentManager =
                getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                setInitialFragment();
                break;
        }
        return true;
    }
}