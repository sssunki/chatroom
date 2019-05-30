package com.example.chatroom.registerActivity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chatroom.R;
import com.example.chatroom.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        ActivityRegisterBinding activityRegisterBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_register);
        ;
        RegisterModel registerModel = new RegisterModel(this, activityRegisterBinding);
        activityRegisterBinding.setRegisterModel(registerModel);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
