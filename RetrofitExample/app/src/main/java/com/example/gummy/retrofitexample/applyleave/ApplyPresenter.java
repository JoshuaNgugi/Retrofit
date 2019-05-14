package com.example.gummy.retrofitexample.applyleave;

import com.example.gummy.retrofitexample.networking.NetworkingUtils;
import com.example.gummy.retrofitexample.networking.UserService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplyPresenter implements ApplyContract.Presenter{

    private ApplyContract.View mView;
    private UserService mUserService = NetworkingUtils.getUserApiInstance();

    public ApplyPresenter(ApplyContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void applyLeave(String token, String type, String from, String to, String number) {
        String bearer = "Bearer " + token;
        mUserService.applyLeaveService(bearer, type, from, to, number)
                .enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String s = response.body().string();
                        JSONObject jsonObject = new JSONObject(s);
                        boolean error = jsonObject.getBoolean("error");
                        if (!error) {
                            mView.displayResult(s);
                        } else {
                            mView.displayResult(s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mView.displayResult("An error occurred.");
            }
        });
    }
}
