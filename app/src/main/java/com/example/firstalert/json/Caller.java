package com.example.firstalert.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class Caller{
    @JsonProperty("S")
    public String s;
}
