package com.example.firstalert;

import android.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.*;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstalert.dummy.DummyContent.DummyItem;
import com.example.firstalert.json.Item;

import java.io.Serializable;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mValues;
    private final Context context;

    public MyItemRecyclerViewAdapter(List<Item> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(v -> {
            ((MainActivity)context).setIncidentView(holder);
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getCaller().getS());
        holder.notes.setText("Notes: "+mValues.get(position).getNotes().getS());

        int fire_vis = mValues.get(position).getFire_dept().getbOOL() ? View.VISIBLE : View.INVISIBLE;
        int police_vis = mValues.get(position).getPolice_dept().getbOOL() ? View.VISIBLE : View.INVISIBLE;
        int emt_vis = mValues.get(position).getEmt_dept().getbOOL() ? View.VISIBLE : View.INVISIBLE;

        holder.fire.setVisibility(fire_vis);
        holder.police.setVisibility(police_vis);
        holder.emt.setVisibility(emt_vis);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final TextView notes;
        public Item mItem;

        public final ImageView fire, emt, police;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            notes = view.findViewById(R.id.brief_notes);
            mContentView = (TextView) view.findViewById(R.id.content);

            fire = view.findViewById(R.id.fire_icon);
            police = view.findViewById(R.id.police_icon);
            emt = view.findViewById(R.id.emt_icon);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}