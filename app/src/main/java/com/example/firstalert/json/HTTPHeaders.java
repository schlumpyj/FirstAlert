package com.example.firstalert.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HTTPHeaders{
    public String server;
    public String date;
    @JsonProperty("content-type")
    public String contentType;
    @JsonProperty("content-length")
    public String contentLength;
    public String connection;
    @JsonProperty("x-amzn-requestid")
    public String xAmznRequestid;
    @JsonProperty("x-amz-crc32")
    public String xAmzCrc32;
}
