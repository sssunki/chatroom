package com.example.chatroom.registerActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.chatroom.logInActivity.LoginActivity;
import com.example.chatroom.databinding.ActivityRegisterBinding;

/**
 * author: ski
 * 注册activity的viewModel
 * 负责注册过程中数据收集工作
 *
 */


public class RegisterModel {

    private ActivityRegisterBinding mActivityRegisterBinding;
    private Activity mRegisterActivtiy;

    private String account;
    private String password;
    private String nickName;

    RegisterModel(Activity activity,  ActivityRegisterBinding activityRegisterBinding) {
        this.mActivityRegisterBinding = activityRegisterBinding;
        this.mRegisterActivtiy = activity;
    }

    /**
     * 注册用方法，和注册按钮绑定
     */
    public void register() {
        if (getRegisterData()) {
            if (postDataToServer())
                backToLogIn();
        }
    }

    private boolean getRegisterData(){
        // 检验信息是否为空
        if( (mActivityRegisterBinding.registerAccount.getText().length() == 0)
                || (mActivityRegisterBinding.registerName.getText().length() == 0)
                || (mActivityRegisterBinding.registerPassword.getText().length() == 0)
                || (mActivityRegisterBinding.registerPasswordAgain.getText().length() == 0)){
            Toast.makeText(mRegisterActivtiy,"请完善信息",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            if(!mActivityRegisterBinding.registerPassword.getText()
                    .equals(mActivityRegisterBinding.registerPasswordAgain.getText())){
                Toast.makeText(mRegisterActivtiy,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
                return false;
            }else {
                // 获取信息
                account = mActivityRegisterBinding.registerAccount.getText().toString();
                password = mActivityRegisterBinding.registerPassword.getText().toString();
                nickName = mActivityRegisterBinding.registerName.getText().toString();
                return true;
            }
        }
    }

    private boolean postDataToServer(){
        int code;
        return true;
    }

    private void backToLogIn(){
        mRegisterActivtiy.finish();
    }
}
