package com.example.gummy.retrofitexample.networking;

import com.example.gummy.retrofit.model.User;

public class UserLogin {
    public static void loginUser(final Callback<User> callback) {
        NetworkingUtils.getUserApiInstance();
    }

    public static void postLogin(final Callback<User> callback) {
        NetworkingUtils.getUserApiInstance();
    }
}
