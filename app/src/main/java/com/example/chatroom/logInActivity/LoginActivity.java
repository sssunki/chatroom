package com.example.chatroom.logInActivity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chatroom.R;
import com.example.chatroom.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding;
        LogInModel logInModel;
        setContentView(R.layout.activity_login);
        activityLoginBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_login);
        logInModel = new LogInModel(this, activityLoginBinding);
        activityLoginBinding.setLoginModel(logInModel);
    }

}
