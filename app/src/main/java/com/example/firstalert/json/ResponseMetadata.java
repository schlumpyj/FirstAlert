package com.example.firstalert.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMetadata{
    @JsonProperty("RequestId")
    public String requestId;
    @JsonProperty("HTTPStatusCode")
    public int hTTPStatusCode;
    @JsonProperty("HTTPHeaders")
    public HTTPHeaders hTTPHeaders;
    @JsonProperty("RetryAttempts")
    public int retryAttempts;
}
