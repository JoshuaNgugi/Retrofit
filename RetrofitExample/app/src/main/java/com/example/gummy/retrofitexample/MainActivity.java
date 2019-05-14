package com.example.gummy.retrofitexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gummy.retrofitexample.networking.NetworkingUtils;
import com.example.gummy.retrofitexample.networking.UserService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText mEditEmpNumber;
    private EditText mEditPassword;
    private Button mButtonLogin;
    private Context mContext = this;
    private UserService mUserService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonLogin = (Button) findViewById(R.id.button_login);
        mEditPassword = (EditText) findViewById(R.id.edit_password);
        mEditEmpNumber = (EditText) findViewById(R.id.edit_employee_number);

        mUserService = NetworkingUtils.getUserApiInstance();
        mButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String mNumber, mPassword;
        mNumber = mEditEmpNumber.getText().toString();
        mPassword = mEditPassword.getText().toString();

        if (!mNumber.isEmpty() && !mPassword.isEmpty()) {
            loginUser(mNumber, mPassword);
        }
    }

    private void loginUser(String mNumber, String mPassword) {
        mUserService.loginUser(mNumber, mPassword).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    //Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
                    try {
                        String s = response.body().string();
                        Log.i(TAG, "onResponse: " + s);
                        JSONObject jsonObject = new JSONObject(s);
                        boolean error = jsonObject.getBoolean("error");
                        if (!error)
                            Toast.makeText(mContext, "No error", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: Error occurred." );
            }
        });
    }
}

