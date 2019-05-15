package com.example.gummy.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {
    @SerializedName("error")
    private boolean error;

    @SerializedName("access_token")
    private String token;

    public DefaultResponse(boolean error, String token) {
        this.error = error;
        this.token = token;
    }

    public boolean isError() {
        return error;
    }

    public String getToken() {
        return token;
    }
}
