package com.example.chatroom.chatActivity.viewModel.dataModel;

public class Friend {

    public String name;
    public int account;

    public Friend(String name, int account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
