package com.example.chatroom.chatActivity.viewModel;

import com.example.chatroom.chatActivity.viewModel.dataModel.User;

import java.util.List;

public interface ChatViewModelInterface {
    void changeCurrentContact(String name, int account);
    void sendMessageTo(String name, int account, String message);
    void onViewInitFinished();
    List getFriendList();
    List getMessageContactList();
    User getUser();
}
