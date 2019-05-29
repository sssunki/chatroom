package com.example.chatroom.chatActivity.view;

import com.example.chatroom.chatActivity.viewModel.dataModel.Friend;
import com.example.chatroom.chatActivity.viewModel.dataModel.Message;
import com.example.chatroom.chatActivity.viewModel.dataModel.MessageContact;

import java.util.List;

public interface ChatViewInterface {
    void setFriendList(List<Friend> friendList);
    void setMessageContactList(List<MessageContact> messageContactList);
    void setMessageList(List<Message> messages);
    void scrollToChatWindow();
}
