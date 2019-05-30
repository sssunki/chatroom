package com.example.chatroom.logInActivity;

import android.databinding.ObservableField;

public class LogInAccount {
    private ObservableField<String> userName;
    private ObservableField<String> password;

    LogInAccount(){}

    LogInAccount(String userName, String password){
        this.userName = new ObservableField<>(userName);
        this.password = new ObservableField<>(password);
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public void setUserName(ObservableField<String> userName) {
        this.userName = userName;
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    public void setPassword(ObservableField<String> password) {
        this.password = password;
    }
}
