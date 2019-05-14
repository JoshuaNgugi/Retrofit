package com.example.gummy.retrofitexample.applyleave;

import com.example.gummy.retrofitexample.BasePresenter;
import com.example.gummy.retrofitexample.BaseView;

public interface ApplyContract {

    interface View extends BaseView {
        void displayResult(String result);
    }

    interface Presenter extends BasePresenter {
        void applyLeave(String token, String type, String from, String to, String number);
    }
}
