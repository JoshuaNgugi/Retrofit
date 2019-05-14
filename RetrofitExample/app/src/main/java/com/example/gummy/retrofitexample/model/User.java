package com.example.gummy.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("employee_no")
    private String mEmployeeNumber;

    @SerializedName("password")
    private String mPassword;

    public User(String mEmployeeNumber, String mPassword) {
        this.mEmployeeNumber = mEmployeeNumber;
        this.mPassword = mPassword;
    }

    public String getmEmployeeNumber() {
        return mEmployeeNumber;
    }

    public void setmEmployeeNumber(String mEmployeeNumber) {
        this.mEmployeeNumber = mEmployeeNumber;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "number = '" + mEmployeeNumber + '\'' +
                ",password = '" + mPassword + '\'' +
                "}";
    }
}
