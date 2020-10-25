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
    private Caller caller;
    private Image image;
    private Urgent urgent;
    private EmtDept emt_dept;
    private Notes notes;
    private PoliceDept police_dept;
    private Id id;
    private Lat lat;
    private Long lon;
    private FireDept fire_dept;

    public Caller getCaller() {
        return caller;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Urgent getUrgent() {
        return urgent;
    }

    public void setUrgent(Urgent urgent) {
        this.urgent = urgent;
    }

    public EmtDept getEmt_dept() {
        return emt_dept;
    }

    public void setEmt_dept(EmtDept emt_dept) {
        this.emt_dept = emt_dept;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public PoliceDept getPolice_dept() {
        return police_dept;
    }

    public void setPolice_dept(PoliceDept police_dept) {
        this.police_dept = police_dept;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Lat getLat() {
        return lat;
    }

    public void setLat(Lat lat) {
        this.lat = lat;
    }

    public Long getLon() {
        return lon;
    }

    public void setLon(Long lon) {
        this.lon = lon;
    }

    public FireDept getFire_dept() {
        return fire_dept;
    }

    public void setFire_dept(FireDept fire_dept) {
        this.fire_dept = fire_dept;
    }
}


