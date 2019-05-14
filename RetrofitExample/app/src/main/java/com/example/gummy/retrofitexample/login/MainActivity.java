package com.example.gummy.retrofitexample.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gummy.retrofitexample.R;
import com.example.gummy.retrofitexample.applyleave.ApplyLeaveActivity;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, MainContract.View {

    private EditText mEditEmpNumber;
    private EditText mEditPassword;
    private Button mButtonLogin;
    private Context mContext = this;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter = new MainPresenter(this);
        mMainPresenter.start();
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
    public void passToken(String token) {
        Intent intent = new Intent(this, ApplyLeaveActivity.class);
        intent.putExtra("AUTH_TOKEN", token);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        String number = mEditEmpNumber.getText().toString();
        String password = mEditPassword.getText().toString();
        mMainPresenter.loginUser(number, password);
    }
}

