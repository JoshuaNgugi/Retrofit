package com.example.gummy.retrofitexample.networking;

import com.example.gummy.retrofitexample.model.User;

public class UserLogin {
    public static void loginUser(final Callback<User> callback) {
        NetworkingUtils.getUserApiInstance();
    }
}
