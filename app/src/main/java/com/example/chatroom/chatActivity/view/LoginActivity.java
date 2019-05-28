package com.example.chatroom.chatActivity.view;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chatroom.R;
import com.example.chatroom.chatActivity.viewModel.LogInModel;
import com.example.chatroom.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding activityLoginBinding;
    private LogInModel logInModel;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_login);
        activityLoginBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_login);
        logInModel = new LogInModel();
        activityLoginBinding.setLoginModel(logInModel);
    }

    public static Context getLoginActivity(){
        return context;
    }
}
