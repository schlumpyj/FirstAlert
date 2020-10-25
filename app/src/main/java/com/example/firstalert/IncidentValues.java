package com.example.firstalert;

import java.io.Serializable;

public class IncidentValues implements Serializable {
    private String imageURL;
    private String caller;
    private boolean fire;
    private boolean emt;
    private boolean police;
    private String notes;
    private boolean urgent;

    public IncidentValues(String imageURL, String caller) {
        this.imageURL = imageURL;
        this.caller = caller;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getCaller() {
        return caller;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isPolice() {
        return police;
    }

    public void setPolice(boolean police) {
        this.police = police;
    }

    public boolean isEmt() {
        return emt;
    }

    public void setEmt(boolean emt) {
        this.emt = emt;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }
}