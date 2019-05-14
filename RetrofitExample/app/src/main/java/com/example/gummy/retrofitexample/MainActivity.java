package com.example.gummy.retrofitexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gummy.retrofitexample.contract.MainContract;
import com.example.gummy.retrofitexample.networking.NetworkingUtils;
import com.example.gummy.retrofitexample.networking.UserService;
import com.example.gummy.retrofitexample.presenter.MainPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText mEditEmpNumber;
    private EditText mEditPassword;
    private Button mButtonLogin;
    private Context mContext = this;
    private UserService mUserService;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter = new MainPresenter(this);
        mMainPresenter.start();

        mUserService = NetworkingUtils.getUserApiInstance();
        mButtonLogin.setOnClickListener(this);
    }

    @Override
    public void init() {
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mEditPassword = (EditText) findViewById(R.id.edit_password);
        mEditEmpNumber = (EditText) findViewById(R.id.edit_employee_number);
    }

    @Override
    public void displayMsg(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String number = mEditEmpNumber.getText().toString();
        String password = mEditPassword.getText().toString();
        mMainPresenter.loginUser(number, password);
    }
}

