package com.example.chatroom.RegisterActivity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chatroom.R;
import com.example.chatroom.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    public static ActivityRegisterBinding mActivityRegisterBinding;
    public static Context registerActivity;
    private RegisterModel mRegisterModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        registerActivity = this;
        mRegisterModel = new RegisterModel();
        mActivityRegisterBinding.setRegisterModel(mRegisterModel);
    }

    public static ActivityRegisterBinding getmActivityRegisterBinding() {
        return mActivityRegisterBinding;
    }

    public static Context getContext() {
        return registerActivity;
    }
}
