package com.example.firstalert.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class EmtDept implements Serializable {
    @JsonProperty("BOOL")
    private boolean bOOL;

    public void setbOOL(boolean bOOL) {
        this.bOOL = bOOL;
    }

    public boolean getbOOL() {
        return bOOL;
    }
}
