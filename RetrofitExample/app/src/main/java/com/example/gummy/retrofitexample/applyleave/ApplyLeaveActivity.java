package com.example.gummy.retrofitexample.applyleave;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gummy.retrofitexample.R;

public class ApplyLeaveActivity extends AppCompatActivity implements ApplyContract.View {

    private EditText mEditType;
    private EditText mEditFrom;
    private EditText mEditTo;
    private EditText mEditNumber;
    private Button mButtonApply;
    private Context mContext = this;
    private ApplyContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_leave);

        mPresenter = new ApplyPresenter(this);
        mPresenter.start();

        final String token = getIntent().getStringExtra("AUTH_TOKEN");
        mButtonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.applyLeave(token,
                        mEditType.getText().toString(),
                        mEditFrom.getText().toString(),
                        mEditTo.getText().toString(),
                        mEditNumber.getText().toString());
            }
        });
    }

    @Override
    public void displayResult(String result) {
        Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
    }

    @Override
    public void init() {
        mEditTo = (EditText) findViewById(R.id.edit_to);
        mEditNumber = (EditText) findViewById(R.id.edit_number);
        mEditFrom = (EditText) findViewById(R.id.edit_from);
        mEditType = (EditText) findViewById(R.id.edit_leave_type);
        mButtonApply = (Button) findViewById(R.id.button_apply);
    }
}
