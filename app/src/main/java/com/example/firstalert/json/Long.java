package com.example.firstalert.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Long implements Serializable {
    @JsonProperty("S")
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
