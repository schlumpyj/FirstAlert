package com.example.firstalert.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PoliceDept implements Serializable {
    @JsonProperty("BOOL")
    private boolean bOOL;

    public void setbOOL(boolean bOOL) {
        this.bOOL = bOOL;
    }

    public boolean getbOOL() {
        return bOOL;
    }
}
