package com.example.chatroom.logInActivity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.example.chatroom.Bean.User;
import com.example.chatroom.chatActivity.view.ChatActivity;
import com.example.chatroom.registerActivity.RegisterActivity;
import com.example.chatroom.databinding.ActivityLoginBinding;

/**
 *  author ：ski
 *  登陆界面的viewModel
 *  负责登陆和跳转到注册界面的工作
 *
 */
public class LogInModel {

    private static final String TAG = "LogInModel";
    private ActivityLoginBinding mActivityLoginBinding;
    private Activity logInActivity;
    private LogInAccount account;


     LogInModel(Activity logInActivity, ActivityLoginBinding activityLoginBinding, LogInAccount account){
        this.mActivityLoginBinding = activityLoginBinding;
        this.logInActivity = logInActivity;
        this.account = account;
    }

    /**
     * 登陆用方法，和登陆按钮绑定
     */
    public void LogIn() {
        if (getData()){
            saveAccount();
            if (postDataToServer()){
                goToChat();
            }
        }
    }


    private boolean getData(){
        if(mActivityLoginBinding.liAccount.getText().length() == 0 ||
            (mActivityLoginBinding.liPassword.getText().length() == 0)){
            Toast.makeText(logInActivity,"请完善信息",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            account = new LogInAccount(mActivityLoginBinding.liAccount.getText().toString(),
                    mActivityLoginBinding.liPassword.getText().toString());
            return true;
        }
    }

    private boolean postDataToServer(){
        return true;
    }

    private void goToChat(){
        Intent intent = new Intent(logInActivity, ChatActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        logInActivity.startActivity(intent);
        logInActivity.finish();
    }


    /**
     * 注册用方法，和注册按钮绑定，用于跳转到注册界面
     */
    public  void register(){
        Intent intent = new Intent(logInActivity, RegisterActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        logInActivity.startActivity(intent);
    }

    private void saveAccount(){
        SharedPreferences sharedPreferences = logInActivity.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putString("account",mActivityLoginBinding.liAccount.getText().toString());
        editor.apply();
    }

    void getSavedAccount(){
        SharedPreferences sharedPreferences = logInActivity.getSharedPreferences("user",Context.MODE_PRIVATE);
        if(sharedPreferences.contains("account")){
            account.setUserName(new ObservableField<String>(
                    sharedPreferences.getString("acconut", " ")));
            account.getUserName().set(sharedPreferences.getString("account"," "));
        }
    }
}
