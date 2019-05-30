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
        init();
    }

    private void init() {
        ActivityLoginBinding activityLoginBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_login);
        LogInAccount logInAccount = new LogInAccount();
        LogInModel logInModel = new LogInModel(this, activityLoginBinding, logInAccount);
        activityLoginBinding.setLoginModel(logInModel);
        activityLoginBinding.setLogInAccount(logInAccount);
        logInModel.getSavedAccount();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
