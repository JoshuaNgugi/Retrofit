package com.example.gummy.retrofitexample.login;

import com.example.gummy.retrofitexample.BasePresenter;
import com.example.gummy.retrofitexample.BaseView;

public interface MainContract {

    interface View extends BaseView {
        void displayMsg(String message);
        void passToken(String token);
    }

    interface Presenter extends BasePresenter {
        void loginUser(String number, String password);
    }
}
