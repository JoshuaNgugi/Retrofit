package com.example.gummy.retrofitexample.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {

    private static Retrofit sRetrofit;
    private static Gson sGson;
    private static final String BASE_URL = "http://ellixar.com/leave/api/";

    public static synchronized Retrofit getInstance() {

        if (sRetrofit == null) {
            if (sGson == null) {
                sGson = new GsonBuilder().setLenient().create();
            }

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(sGson))
                    .build();
        }
        return sRetrofit;
    }
}
