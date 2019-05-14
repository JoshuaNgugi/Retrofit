package com.example.gummy.retrofitexample.login;

import android.util.Log;

import com.example.gummy.retrofitexample.networking.NetworkingUtils;
import com.example.gummy.retrofitexample.networking.UserService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private static final String TAG = "MainPresenter";
    private UserService mUserService = NetworkingUtils.getUserApiInstance();

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void loginUser(String number, String password) {
        mUserService.loginUserService(number, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String s = response.body().string();
                        Log.i(TAG, "onResponse: " + s);
                        JSONObject jsonObject = new JSONObject(s);
                        boolean error = jsonObject.getBoolean("error");
                        if (!error) {
                            mView.displayMsg("No error");
                            String authToken = jsonObject.getString("access_token");
                            //mView.displayMsg(authToken);
                            mView.passToken(authToken);
                        }
                        else
                            mView.displayMsg("Error");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mView.displayMsg("Error occurred.");
                Log.e(TAG, "onFailure: Error occurred.");
            }
        });
    }


}
