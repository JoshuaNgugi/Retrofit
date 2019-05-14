package com.example.gummy.retrofitexample.networking;

import android.database.Observable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ResponseBody> loginUser(
            @Field("employee_no") String employee_no,
            @Field("password") String password
    );

    @POST("auth/login")
    Observable<ResponseBody> loginUserAgain(
            @Field("employee_no") String employee_no,
            @Field("password") String password
    );
}
