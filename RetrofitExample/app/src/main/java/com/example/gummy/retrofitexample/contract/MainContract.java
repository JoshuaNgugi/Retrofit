package com.example.gummy.retrofitexample.contract;

public interface MainContract {
    interface View {
        void init();
        void displayMsg(String message);
    }

    interface Presenter {
        void start();
        void loginUser(String number, String password);
    }
}
