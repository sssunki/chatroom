package com.example.chatroom.chatActivity.viewModel.dataModel;

public class MessageContact {

    public String name;
    public String lastMessage;
    private int account;

    public MessageContact(String name, String lastMessage, int account) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
