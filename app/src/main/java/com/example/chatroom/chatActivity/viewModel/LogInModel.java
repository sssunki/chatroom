package com.example.chatroom.chatActivity.viewModel;


import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.chatroom.Utils.MyApplication;
import com.example.chatroom.chatActivity.view.ChatActivity;
import com.example.chatroom.chatActivity.view.LoginActivity;
import com.example.chatroom.chatActivity.view.RegisterActivity;
import com.example.chatroom.databinding.ActivityLoginBinding;

/**
 *  author ：ski
 *  登陆界面的viewModel
 *  负责登陆和跳转到注册界面的工作
 *
 */
public class LogInModel {

    private static final String TAG = "LogInModel";
    private ActivityLoginBinding activityLoginBinding;
    private Context context;


    /**
     * 登陆用方法，和登陆按钮绑定
     */
    public void LogIn(){
        Log.d(TAG, "LogIn: start log in");
        // activityLoginBinding.liAccount.getText();
        // activityLoginBinding.liPassword.getText();
        // Intent intent = new Intent("com.example.chatroom.chatActivity.view.CHAT_ACTIVITY");
        context = LoginActivity.getLoginActivity();
        Intent intent = new Intent(context, ChatActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        // MyApplication.getContext().startActivity(intent);
    }

    /**
     * 注册用方法，和注册按钮绑定
     */
    public  void register(){
        context = LoginActivity.getLoginActivity();
        Intent intent = new Intent(context, RegisterActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
