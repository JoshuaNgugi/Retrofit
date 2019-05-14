package com.example.gummy.retrofitexample.networking;

public class NetworkingUtils {
    private static UserService sUserService;

    public static UserService getUserApiInstance() {
        if (sUserService == null) {
            sUserService = RetrofitAdapter.getInstance().create(UserService.class);
        }
        return sUserService;
    }
}
