package com.example.chatroom.chatActivity.viewModel.dataModel;


public class Account {
    private String nickName;
    private String password;
    private String account;

    public Account(String nickName, String password, String account) {
        this.nickName = nickName;
        this.password = password;
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
