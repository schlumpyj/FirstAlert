package com.example.firstalert.json;

import com.example.firstalert.json.Caller;
import com.example.firstalert.json.EmtDept;
import com.example.firstalert.json.FireDept;
import com.example.firstalert.json.Id;
import com.example.firstalert.json.Image;
import com.example.firstalert.json.Lat;
import com.example.firstalert.json.Long;
import com.example.firstalert.json.Notes;
import com.example.firstalert.json.PoliceDept;
import com.example.firstalert.json.Urgent;

import java.io.Serializable;


public class Item implements Serializable {
    public Caller caller;
    public Image image;
    public Urgent urgent;
    public EmtDept emt_dept;
    public Notes notes;
    public PoliceDept police_dept;
    public Id id;
    public Lat lat;
    public Long lon;
    public FireDept fire_dept;
}


