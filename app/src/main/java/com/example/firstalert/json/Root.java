package com.example.firstalert.json;

import com.example.firstalert.json.ResponseMetadata;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root{
    @JsonProperty("Items")
    public List<Item> items;
    @JsonProperty("Count")
    public int count;
    @JsonProperty("ScannedCount")
    public int scannedCount;
    @JsonProperty("ResponseMetadata")
    public ResponseMetadata responseMetadata;
}
