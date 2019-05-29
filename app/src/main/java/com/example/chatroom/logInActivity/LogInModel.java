package com.example.chatroom.chatActivity.viewModel;


import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.chatroom.R;
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

    private String account;
    private String password;

    /**
     * 登陆用方法，和登陆按钮绑定
     */
    public void LogIn(){
        Log.d(TAG, "LogIn: start log in");
        context = LoginActivity.getLoginActivity();  // 获取loginactivity实例
        activityLoginBinding = LoginActivity.getActivityLoginBinding();


        // 判断帐号密码栏是否为空
        if(activityLoginBinding.liAccount.getText().length() == 0){
            Toast.makeText(context,"请输入帐号",Toast.LENGTH_SHORT).show();
        }else {
            if(activityLoginBinding.liPassword.getText().length() == 0){
                Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT).show();
            }else {
                // 发送帐号密码信息
                account = activityLoginBinding.liAccount.getText().toString();
                password = activityLoginBinding.liPassword.getText().toString();

                // 服务器返回是否正确

                // 进入聊天界面
                Intent intent = new Intent(context, ChatActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }

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
